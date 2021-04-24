package proyecto.escalab.microservicio.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import proyecto.escalab.microservicio.users.entities.User;
import proyecto.escalab.microservicio.users.entities.UserInRole;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Integer> {

	@Query("SELECT u.user FROM UserInRole u WHERE u.role.name = $1")
	public List<User> findUserByRoleName(String rolName);
	
	public List<UserInRole> findByUser(User user);
}
