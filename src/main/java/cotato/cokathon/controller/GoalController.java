package cotato.cokathon.controller;

import cotato.cokathon.apipayload.ApiResponse;
import cotato.cokathon.dto.request.GoalCreateRequest;
import cotato.cokathon.dto.response.GoalCreateResponse;
import cotato.cokathon.service.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "유저 버킷리스트", description = "유저 버킷리스트 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    @PostMapping
    @Operation(summary = "유저 버킷리스트 생성", description = "선택한 버킷리스트 수만큼 유저 버킷리스트를 생성합니다")
    public ApiResponse<GoalCreateResponse> createGoal(@RequestBody GoalCreateRequest goalCreateRequest) {
        return ApiResponse.onSuccess(goalService.createGoal(goalCreateRequest));
    }
}
