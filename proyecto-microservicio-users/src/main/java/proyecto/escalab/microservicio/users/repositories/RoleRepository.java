package proyecto.escalab.microservicio.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.escalab.microservicio.users.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
