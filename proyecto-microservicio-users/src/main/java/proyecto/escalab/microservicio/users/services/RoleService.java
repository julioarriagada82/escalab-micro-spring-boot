package proyecto.escalab.microservicio.users.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import proyecto.escalab.microservicio.users.entities.Role;
import proyecto.escalab.microservicio.users.entities.User;
import proyecto.escalab.microservicio.users.models.Devs4jSecurityRule;
import proyecto.escalab.microservicio.users.repositories.RoleRepository;
import proyecto.escalab.microservicio.users.repositories.UserInRoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserInRoleRepository userInRoleRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
	
	//@RolesAllowed({"ROLE_ADMIN"})
	@Devs4jSecurityRule
	public List<User> getUserByRoleName(String roleName) {
		log.info("Getting roles by name {} ", roleName);
		return userInRoleRepository.findUserByRoleName(roleName);
	}
	
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role updateRole(Integer roleId, Role role) {
		
		Optional<Role> result = roleRepository.findById(roleId);
		
		if(result.isPresent()) {
			return roleRepository.save(role);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
		}
	}
	
	public void eliminar (Integer id) {
		roleRepository.deleteById(id);
	}

	public void deleteRole(Integer roleId) {
Optional<Role> result = roleRepository.findById(roleId);
		
		if(result.isPresent()) {
			roleRepository.deleteById(roleId);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
		}
	}
}
