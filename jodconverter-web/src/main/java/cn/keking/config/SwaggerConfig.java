package cn.keking.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * <p>Title: SwaggerConfig</p>
 * <p>Description: Swagger配置类</p>
 * <p>Company: http://www.wootion.com/</p>
 * <p>create date: 2020/03/18</p>
 *
 * @author :tanhuan
 * @version :1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public SwaggerConfig() {
    }

    @Bean
    public Docket createRestApi() {
        return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }

}

