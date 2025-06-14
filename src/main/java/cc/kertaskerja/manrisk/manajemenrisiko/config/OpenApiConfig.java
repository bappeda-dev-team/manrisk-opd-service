package cc.kertaskerja.manrisk.manajemenrisiko.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Manajemen Risiko API")
                        .version("1.0.0")
                        .description("API untuk manajemen risiko")
                        .contact(new Contact()
                                .name("API Support")
                                .email("support@example.com")));
    }
}