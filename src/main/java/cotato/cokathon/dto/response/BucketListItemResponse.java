package cotato.cokathon.dto.response;

import cotato.cokathon.entity.bucketList.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BucketListItemResponse {

    private Long id;
    private Category category;
    private String content;
}
