package cotato.cokathon.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JoinDTO {

    private String username;
    private String password;
    private String name;
    private LocalDate birthdate;
}