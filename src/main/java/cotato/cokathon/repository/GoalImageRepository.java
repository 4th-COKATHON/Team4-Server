package cotato.cokathon.repository;

import cotato.cokathon.entity.goal.GoalImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalImageRepository extends JpaRepository<GoalImage, Long> {

    Optional<GoalImage> findByGoal_Id(Long goalId);
}
