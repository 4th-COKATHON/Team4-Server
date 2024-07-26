package cotato.cokathon.service;

import cotato.cokathon.dto.response.BucketListItemResponse;
import cotato.cokathon.dto.response.BucketListResponse;
import cotato.cokathon.entity.bucketList.BucketList;
import cotato.cokathon.entity.bucketList.Category;
import cotato.cokathon.repository.BucketListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BucketListService {

    private final BucketListRepository bucketListRepository;

    public BucketListResponse getBucketList() {

        List<BucketList> bucketLists = bucketListRepository.findAllByOrderByCategoryAsc();
        List<BucketListItemResponse> bucketListItemResponses = new ArrayList<>();

        for (BucketList bucketList : bucketLists) {

            BucketListItemResponse bucketListItemResponse = BucketListItemResponse.builder()
                    .id(bucketList.getId())
                    .category(bucketList.getCategory())
                    .content(bucketList.getContent())
                    .build();

            bucketListItemResponses.add(bucketListItemResponse);
        }

        return new BucketListResponse(bucketListItemResponses);
    }

    public BucketListResponse getBucketListByCategory(Category category) {

        List<BucketList> bucketLists = bucketListRepository.findAllByCategory(category);
        List<BucketListItemResponse> bucketListItemResponses = new ArrayList<>();

        for (BucketList bucketList : bucketLists) {

            BucketListItemResponse bucketListItemResponse = BucketListItemResponse.builder()
                    .id(bucketList.getId())
                    .category(bucketList.getCategory())
                    .content(bucketList.getContent())
                    .build();

            bucketListItemResponses.add(bucketListItemResponse);
        }

        return new BucketListResponse(bucketListItemResponses);
    }
}
