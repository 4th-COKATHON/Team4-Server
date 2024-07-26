package cotato.cokathon.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalDetailResponse {

    private Long id;
    private String category;
    private String content;
    private String comment;
    private Boolean finished;
    private LocalDateTime dueDate;
    private Integer year;
    private LocalDateTime finishedDate;
    private String image_url;
}
