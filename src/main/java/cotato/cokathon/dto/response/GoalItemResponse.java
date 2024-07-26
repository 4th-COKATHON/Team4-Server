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
public class GoalItemResponse {

    private Long id;
    private String content;
    private Boolean finished;
    private LocalDateTime dueDate;
}
