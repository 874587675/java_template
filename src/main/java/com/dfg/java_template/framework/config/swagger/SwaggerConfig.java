package com.dfg.java_template.framework.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableKnife4j
public class SwaggerConfig {

    // 后台模块
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理模块")
                .apiInfo(apiInfo("后台管理模块", "后台相关接口"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfg.java_template.business.controller.back"))
                .paths(PathSelectors.any())
                .build();
    }

    // 前台模块
    @Bean
    public Docket frontApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("前台用户模块")
                .apiInfo(apiInfo("前台用户模块", "前台用户相关接口"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfg.java_template.business.controller.front"))
                .paths(PathSelectors.any())
                .build();
    }

    // 通用模块
    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用模块")
                .apiInfo(apiInfo("通用模块", "通用接口"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfg.java_template.business.controller.common"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .contact(new Contact("张广成", description, "874587675@qq.com"))
                .title(title)
                .description(description)
                .version("V1.0")
                .build();
    }
}
