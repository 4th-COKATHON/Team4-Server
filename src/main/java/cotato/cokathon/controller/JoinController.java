package cotato.cokathon.controller;

import cotato.cokathon.apipayload.ApiResponse;
import cotato.cokathon.dto.JoinDTO;
import cotato.cokathon.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ApiResponse<?> joinProcess(JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);
        return ApiResponse.onSuccess("회원가입 성공");
    }
}
