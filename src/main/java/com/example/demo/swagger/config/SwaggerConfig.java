package com.example.demo.swagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition (
        info = @Info(title = "새싹챗 리팩토링 API 명세서",
        description = "웹소켓을 이용하여 실시간 채팅 서비스를 제공하는 '새싹챗' 프로젝트를 리팩토링한 API 명세서입니다.",
        version = "v1")
)
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatApi(){

        return GroupedOpenApi.builder()
                .group("채팅 서비스 리팩토링 API")
                .pathsToMatch("/**")
                .build();
    }

}
