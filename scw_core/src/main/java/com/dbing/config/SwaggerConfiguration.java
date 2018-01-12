package com.dbing.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * author:dbing
 *
 * 注意：要将该bean  配置到SpringMVC容器中
 *
 */
@EnableSwagger2//开启Swagger
public class SwaggerConfiguration{
    //返回Swagger的文档对象
    @Bean
    public Docket docket(){

        //ApiInfoBuilder；一般的大对象；我们都应该来写一个构建器（建造者模式）
        //new ApiInfoBuilder().xx.xxx.xxx.build()
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("尚筹网后台restapi接口文档")
                        .license("联合国公约")
                        .licenseUrl("")
                        .contact(new Contact("cever", null, "cbz18170628673@163.com"))
                        .title("尚筹网-api文档")
                        .version("1.0.0.beta").build());
        return docket;
    }
}
