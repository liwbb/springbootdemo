package com.example.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author D N
 * @create 2018-03-22 15:38
 **/
@Configuration
@EnableSwagger2
public class swagger2  {
    @Bean
    public Docket investApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("investor")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootdemo.controller.investController"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(investorApiInfo());
    }
    private ApiInfo investorApiInfo() {
        ApiInfo apiInfo = new ApiInfo("星投资_接口文档_投资人",
                "星投资投资人接口文档",
                "1.0.0",
                "www.xingtouzi.com",
                "星投资",
                "星投资",
                "https://www.xingtouzi.com");
        return apiInfo;
    }
    @Bean
    public Docket borrowerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("borrower")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootdemo.controller.BorrowerController"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(borrowerApiInfo());
    }
    private ApiInfo borrowerApiInfo() {
        ApiInfo apiInfo = new ApiInfo("星投资_接口文档_借款人",
                "星投资投资人接口文档",
                "1.0.0",
                "www.xingtouzi.com",
                "星投资",
                "星投资",
                "https://www.xingtouzi.com");
        return apiInfo;
    }
}
