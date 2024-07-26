package cotato.cokathon.service;

import cotato.cokathon.apipayload.code.status.ErrorStatus;
import cotato.cokathon.apipayload.handler.TempHandler;
import cotato.cokathon.dto.request.GoalCreateRequest;
import cotato.cokathon.dto.response.GoalCreateResponse;
import cotato.cokathon.dto.response.GoalDetailResponse;
import cotato.cokathon.entity.bucketList.BucketList;
import cotato.cokathon.entity.goal.Goal;
import cotato.cokathon.entity.goal.GoalImage;
import cotato.cokathon.repository.BucketListRepository;
import cotato.cokathon.repository.GoalImageRepository;
import cotato.cokathon.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final BucketListRepository bucketListRepository;
    private final GoalImageRepository goalImageRepository;

    @Transactional
    public GoalCreateResponse createGoal(GoalCreateRequest goalCreateRequest) {

        List<Long> goalIds = new ArrayList<>();

        for (Long bucketListId : goalCreateRequest.getBucketListIds()) {

            BucketList bucketList = bucketListRepository.findById(bucketListId)
                    .orElseThrow(() -> new TempHandler(ErrorStatus.BUCKETLIST_NOT_FOUND));

            Goal goal = Goal.builder()
                    .year(LocalDate.now().getYear())
                    .category(bucketList.getCategory().toString())
                    .content(bucketList.getContent())
                    .build();

            goalIds.add(goal.getId());
            goalRepository.save(goal);
        }

        return new GoalCreateResponse(goalIds);
    }

    public GoalDetailResponse getGoalDetail(Long goalId) {

        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.GOAL_NOT_FOUND));

        GoalImage goalImage = goalImageRepository.findByGoal_Id(goalId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.GOAL_NOT_FOUND));

        GoalDetailResponse goalDetailResponse = GoalDetailResponse.builder()
                .category(goal.getCategory())
                .content(goal.getContent())
                .comment(goal.getComment())
                .year(goal.getYear())
                .finished(goal.getFinished())
                .dueDate(goal.getDueDate())
                .finishedDate(goal.getFinishedDate())
                .image_url(goalImage.getImage_url())
                .build();

        return goalDetailResponse;
    }
}
