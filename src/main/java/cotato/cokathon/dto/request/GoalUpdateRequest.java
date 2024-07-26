package cotato.cokathon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoalUpdateRequest {

    private LocalDate dueDate;
    private String comment;
}
