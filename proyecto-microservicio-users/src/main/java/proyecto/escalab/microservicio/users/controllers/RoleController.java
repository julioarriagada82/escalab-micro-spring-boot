package proyecto.escalab.microservicio.users.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.escalab.microservicio.users.entities.Role;
import proyecto.escalab.microservicio.users.entities.User;
import proyecto.escalab.microservicio.users.services.RoleService;

@RestController
//Definicion de mi recurso
@RequestMapping("roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);


	@GetMapping
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<List<Role>> getRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("Name {} ", authentication.getName());
		log.info("Principal {} ", authentication.getPrincipal());
		log.info("Credentials {} ", authentication.getCredentials());
		log.info("Roles {} ", authentication.getAuthorities().toString());
		
		return new ResponseEntity<List<Role>>(roleService.getRoles(), HttpStatus.OK);
	}
	
	@GetMapping("/{roleName}/users")
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<List<User>> getUserByRoleName(@PathVariable("roleName") String roleName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("Name {} ", authentication.getName());
		log.info("Principal {} ", authentication.getPrincipal());
		log.info("Credentials {} ", authentication.getCredentials());
		log.info("Roles {} ", authentication.getAuthorities().toString());
		
		return new ResponseEntity<List<User>>(roleService.getUserByRoleName(roleName), HttpStatus.OK);
	}
	
	@PostMapping
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<Role> createRoles(@RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.createRole(role), HttpStatus.CREATED);
	}
	
	@PutMapping("/{roleId}")
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<Role> updateRoles(@PathVariable("roleId") Integer roleId, @RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.updateRole(roleId, role), HttpStatus.OK);
	}
	
	@DeleteMapping("/{roleId}")
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<Void> deleteRoles(@PathVariable("roleId") Integer roleId) {
		roleService.deleteRole(roleId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
