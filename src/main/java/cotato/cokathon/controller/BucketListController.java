package cotato.cokathon.controller;

import cotato.cokathon.apipayload.ApiResponse;
import cotato.cokathon.dto.response.BucketListResponse;
import cotato.cokathon.entity.bucketList.Category;
import cotato.cokathon.service.BucketListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "버킷리스트", description = "버킷리스트 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/bucketlist")
public class BucketListController {

    private final BucketListService bucketListService;

    @GetMapping("/all")
    @Operation(summary = "전체 버킷리스트 조회", description = "카테고리 기준으로 오름차순 정렬된 전체 버킷리스트를 조회합니다")
    public ApiResponse<BucketListResponse> getBucketList() {
        return ApiResponse.onSuccess(bucketListService.getBucketList());
    }

    @GetMapping
    @Operation(summary = "카테고리별 버킷리스트 조회", description = "카테고리별 버킷리스트를 조회합니다")
    public ApiResponse<BucketListResponse> getBucketListByCategory(@RequestParam(name = "category") Category category) {
        return ApiResponse.onSuccess(bucketListService.getBucketListByCategory(category));
    }
}
