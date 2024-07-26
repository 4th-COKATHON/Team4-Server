package cotato.cokathon.repository;

import cotato.cokathon.entity.goal.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
