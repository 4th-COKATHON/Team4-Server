package cotato.cokathon.apipayload.code.status;

import cotato.cokathon.apipayload.code.BaseCode;
import cotato.cokathon.apipayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    // 에러 응답
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "서버 에러"),

    // 세션 에러
    SESSION_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "유효하지 않은 세션입니다."),

    // 버킷리스트 관련 에러
    BUCKETLIST_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND", "존재하지 않는 버킷리스트입니다"),

    // 유저 버킷리스트 관련 에러
    GOAL_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT FOUND", "존재하지 않는 유저 버킷리스트입니다");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }

}