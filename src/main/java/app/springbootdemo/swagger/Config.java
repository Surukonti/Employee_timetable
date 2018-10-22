package app.springbootdemo.swagger;



import com.google.common.collect.Lists;
import org.springframework.context.annotation.*;
import org.springframework.security.core.context.SecurityContext;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;


@Configuration
@EnableSwagger2
//@ComponentScan("app.springbootdemo.controller")
public class Config {

    @Bean
    public Docket apiApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(basePackage("app.springbootdemo.controller")) //RequestHandlerSelectors.any()
               // .paths(PathSelectors.any())
                .paths(regex("/api.*"))
                .build();


    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/src/resources/");
//
//    }

//    private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "header");
//    }

//@Bean
//SecurityConfiguration security()
//{
//    return new SecurityConfiguration(null, null, null, null,
//        "Bearer access_token", ApiKeyVehicle.HEADER, "Authorization", ","); }

}

