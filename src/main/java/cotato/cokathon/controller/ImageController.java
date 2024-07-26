package cotato.cokathon.controller;

import cotato.cokathon.apipayload.ApiResponse;
import cotato.cokathon.dto.response.GoalDetailResponse;
import cotato.cokathon.service.GoalService;
import cotato.cokathon.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PatchMapping("/goals/{goalId}/achievements")
    public ApiResponse<?> updateAchievements(@PathVariable Long goalId, MultipartRequest multipartRequest) {
        try {
            String s3Url = imageService.imageUpload(multipartRequest);
            GoalDetailResponse goalDetailResponse = imageService.updateGoalDetailImageUrl(goalId, s3Url);
            return ApiResponse.onSuccess(goalDetailResponse);
        } catch (IOException e) {
            return ApiResponse.onFailure("500", "INTERNAL SERVER ERROR", "s3 이미지 저장 실패");
        }
    }

}