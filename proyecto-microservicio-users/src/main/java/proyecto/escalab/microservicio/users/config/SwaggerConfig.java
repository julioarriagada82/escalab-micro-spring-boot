package proyecto.escalab.microservicio.users.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.devs4j.users.controllers"))
				//.paths(PathSelectors.ant("/users/*")).build(); //para uno en especifico
				.paths(PathSelectors.any()).build() //para todos los path
				.useDefaultResponseMessages(false); //para ocultar los codigos de error por defecto
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Devs4j api")
				.version("1.0")
				.license("Apache 2.0")
				.contact(new Contact("@correo.cl","http://www.devs4j.com","contacto@devs4j.com"))
				.build();
	}
	
	

}
