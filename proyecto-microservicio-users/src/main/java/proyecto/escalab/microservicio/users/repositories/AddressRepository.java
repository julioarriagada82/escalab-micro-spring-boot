package proyecto.escalab.microservicio.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import proyecto.escalab.microservicio.users.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("SELECT a from address a WHERE a.profile.user.id=?1 AND a.profile.id=?2")
	List<Address> findByProfileId(Integer userId, Integer profileId);
}
