package cotato.cokathon.dto.request;

import cotato.cokathon.entity.bucketList.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoalCreateRequest {

    private List<Long> bucketListIds;
}
