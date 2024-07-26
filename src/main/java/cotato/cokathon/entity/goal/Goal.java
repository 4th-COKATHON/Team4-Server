package cotato.cokathon.entity.goal;

import cotato.cokathon.entity.BaseEntity;
import cotato.cokathon.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String comment;

    private Boolean finished;

    private LocalDateTime dueDate;

    private Integer year;

    private LocalDateTime finishedDate;

    private String category;

    private String content;

    public Goal updateAchievement() {
        this.finished = true;
        this.finishedDate = LocalDateTime.now();
        return this;
    }
}
