package com.aira.sehirlerin_enerjisi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Şehirlerin Enerjisi API")
                        .version("1.0.0")
                        .description("Konuma göre nükleer reaktörlerin etkisini hesaplayan REST API simülasyon hizmeti.")
                        .contact(new Contact()
                                .name("Şehirlerin Enerjisi Takımı")
                                .email("takim@example.com")
                                .url("https://github.com/sehirlerinenerjisi"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
