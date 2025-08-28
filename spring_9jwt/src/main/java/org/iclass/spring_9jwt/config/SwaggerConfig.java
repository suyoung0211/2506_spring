package org.iclass.spring_9jwt.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// swagger ui 에 Authorization 버튼 추가하고 헤더 입력 표시할때 참고
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("API 문서").version("v1"))  // 문서 제목과 버전
                .components(new Components()  // 보안 스키마 정의
                    .addSecuritySchemes("bearer-key",  // 스키마 이름
                        new SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)         // HTTP 기반 인증
                            .scheme("bearer")                // Bearer 토큰 방식
                            .bearerFormat("JWT")))     // 포맷은 JWT
                .addSecurityItem(new SecurityRequirement()          // 실제 보안 적용
                    .addList("bearer-key"));                   // 위에서 정의한 스키마 이름
    }
}

// swagger ui 오른쪽 상단에 authorize 버튼 생김
/* 또는
 * @SecurityScheme(
    name = "JWT",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
 * 
 * 
 */