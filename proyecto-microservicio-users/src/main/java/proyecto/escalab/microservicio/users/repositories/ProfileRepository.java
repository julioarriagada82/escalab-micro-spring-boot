package proyecto.escalab.microservicio.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import proyecto.escalab.microservicio.users.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	@Query("SELECT p from profile p WHERE p.user.id=?1 AND p.id=?2")
	Optional<Profile> getByIdUserAndProfileId(Integer userId, Integer profileId);
}
