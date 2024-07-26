package cotato.cokathon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoalUpdateRequest {

    private LocalDateTime dueDate;
    private String comment;
}
