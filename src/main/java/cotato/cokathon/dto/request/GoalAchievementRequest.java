package cotato.cokathon.dto.request;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record GoalAchievementRequest(
        @NotNull
        MultipartFile image
) {
}
