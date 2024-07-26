package cotato.cokathon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalFinishedItemResponse {

    private Long id;
    private String content;
    private Boolean finished;
    private String image_url;
}
