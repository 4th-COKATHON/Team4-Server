package cotato.cokathon.service;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import cotato.cokathon.apipayload.code.status.ErrorStatus;
import cotato.cokathon.apipayload.handler.TempHandler;
import cotato.cokathon.config.s3.S3Config;
import cotato.cokathon.dto.response.GoalDetailResponse;
import cotato.cokathon.entity.goal.Goal;
import cotato.cokathon.entity.goal.GoalImage;
import cotato.cokathon.repository.GoalImageRepository;
import cotato.cokathon.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {

    private final S3Config s3Config;

    private final GoalRepository goalRepository;
    private final GoalImageRepository goalImageRepository;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    //로컬 환경에 맞게 바꿔야함
    private String localLocation = "/Users/dong0579/cotato/cokathon/src/main/resources";

    public String imageUpload(MultipartRequest request) throws IOException {

        MultipartFile file = request.getFile("upload");

        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.indexOf("."));

        String uuidFileName = UUID.randomUUID() + ext;
        String localPath = localLocation + uuidFileName;

        File localFile = new File(localPath);
        file.transferTo(localFile);
        log.info("Upload image to local file: " + localFile.getAbsolutePath());


        s3Config.amazonS3Client().putObject(new PutObjectRequest(bucket, uuidFileName, localFile).withCannedAcl(CannedAccessControlList.PublicRead));
        String s3Url = s3Config.amazonS3Client().getUrl(bucket, uuidFileName).toString();

        localFile.delete();

        return s3Url;
    }

    public GoalDetailResponse updateGoalDetailImageUrl(Long goalId, String url) {

        Goal findGoal = goalRepository.findById(goalId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.GOAL_NOT_FOUND));

        Goal updatedGoal = findGoal.updateAchievement(); // goal 완료되게 바꿈

        Goal goal = goalRepository.save(updatedGoal);

        GoalImage goalImage = GoalImage.builder()
                .goal(goal)
                .image_url(url)
                .build();
        goalImageRepository.save(goalImage);

        GoalDetailResponse goalDetailResponse = GoalDetailResponse.builder()
                .category(goal.getCategory())
                .content(goal.getContent())
                .comment(goal.getComment())
                .year(goal.getYear())
                .finished(goal.getFinished())
                .dueDate(goal.getDueDate())
                .finishedDate(goal.getFinishedDate())
                .image_url(url)
                .build();

        return goalDetailResponse;
    }

}
