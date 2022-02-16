package at.htlklu.nsvs.rentApp.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket apiSwaggerConfig() {

        Docket apiDocket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("at.htlklu.nsvs.rentApp"))
                .build()
                .apiInfo(this.getApiInfo());

        return apiDocket;
    }

    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder()
                .title("RentApp-API")
                .description("")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org")
                .contact(new Contact("Rita Hannemann", "https://mainteneer.net", "rita.hannemann@htl-klu.at"))
                .version("1.0")
                .build();
    }
}