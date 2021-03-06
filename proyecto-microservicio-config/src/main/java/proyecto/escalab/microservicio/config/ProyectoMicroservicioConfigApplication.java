package proyecto.escalab.microservicio.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ProyectoMicroservicioConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMicroservicioConfigApplication.class, args);
	}

}
