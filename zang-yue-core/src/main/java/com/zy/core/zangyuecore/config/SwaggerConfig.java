package com.zy.core.zangyuecore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/15$ 15:59$
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * api接口包扫描路径
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.zy";
    public static final String VERSION = "1.0.0";
    @Value("${swagger.enable}")
    public boolean enable = true;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("葬月,多模块开发文档")
                .description("多模块开发文档")
                .license("lhf")
                .version(VERSION)
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }

}
