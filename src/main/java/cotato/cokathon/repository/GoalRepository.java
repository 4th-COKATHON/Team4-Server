package cotato.cokathon.repository;

import cotato.cokathon.entity.goal.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findAllByFinished(Boolean finished);
}
