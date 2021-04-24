package proyecto.escalab.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProyectoMicroservicioEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMicroservicioEurekaApplication.class, args);
	}

}
