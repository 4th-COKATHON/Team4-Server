package cotato.cokathon.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalDetailResponse {

    private Long id;
    private String category;
    private String content;
    private String comment;
    private Boolean finished;
    private LocalDate dueDate;
    private Integer year;
    private LocalDate finishedDate;
    private String image_url;
}
