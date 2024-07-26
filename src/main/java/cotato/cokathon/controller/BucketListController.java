package cotato.cokathon.controller;

import cotato.cokathon.apipayload.ApiResponse;
import cotato.cokathon.dto.response.BucketListResponse;
import cotato.cokathon.entity.bucketList.Category;
import cotato.cokathon.service.BucketListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bucketlist")
public class BucketListController {

    private final BucketListService bucketListService;

    @GetMapping("/all")
    public ApiResponse<BucketListResponse> getBucketList() {
        return ApiResponse.onSuccess(bucketListService.getBucketList());
    }

    @GetMapping
    public ApiResponse<BucketListResponse> getBucketListByCategory(@RequestParam(name = "category") Category category) {
        return ApiResponse.onSuccess(bucketListService.getBucketListByCategory(category));
    }
}
