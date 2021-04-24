package proyecto.escalab.microproducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class ProyectoMicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMicroservicioApplication.class, args);
	}

}
