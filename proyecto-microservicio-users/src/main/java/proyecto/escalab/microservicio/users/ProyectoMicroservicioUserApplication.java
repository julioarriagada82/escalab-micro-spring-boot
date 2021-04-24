package proyecto.escalab.microservicio.users;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import proyecto.escalab.microservicio.users.entities.Role;
import proyecto.escalab.microservicio.users.entities.User;
import proyecto.escalab.microservicio.users.entities.UserInRole;
import proyecto.escalab.microservicio.users.repositories.RoleRepository;
import proyecto.escalab.microservicio.users.repositories.UserInRoleRepository;
import proyecto.escalab.microservicio.users.repositories.UserRepository;
import com.github.javafaker.Faker;


@SpringBootApplication
public class ProyectoMicroservicioUserApplication implements ApplicationRunner {

	@Autowired
	private Faker faker;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private RoleRepository roleRepository; 
	
	@Autowired
	private UserInRoleRepository userInRoleRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger(ProyectoMicroservicioUserApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoMicroservicioUserApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role roles[] = {new Role("ADMIN"), new Role("SUPPORT"), new Role("USER")};
		
		for(Role role: roles) {
			roleRepository.save(role);
		}
		
		for(int i = 0; i < 100; i++) {
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			User created = userRepository.save(user);
			
			UserInRole userInRole = new UserInRole(created, roles[new Random().nextInt(3)]);
			
			log.info("user created username {} password {} role {}", user.getUsername(), user.getPassword(), userInRole.getRole().getName());
			
			userInRoleRepository.save(userInRole);
			
		}
	}

}
