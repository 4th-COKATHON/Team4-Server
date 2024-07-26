package cotato.cokathon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "코커톤 4조 API 명세서",
                description = "코커톤 4조 API 명세서입니다"),
        servers = {@Server(url = "/", description = "Default Server URL")})
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

}