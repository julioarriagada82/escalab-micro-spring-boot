package proyecto.escalab.microservicio.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import proyecto.escalab.microservicio.users.entities.Profile;
import proyecto.escalab.microservicio.users.entities.User;
import proyecto.escalab.microservicio.users.repositories.ProfileRepository;
import proyecto.escalab.microservicio.users.repositories.UserRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Profile getByIdUserIdAndProfileId(Integer userId, Integer profileId) {
		return profileRepository.getByIdUserAndProfileId(userId, profileId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile not found for user %d and profile %d", userId, profileId)));
	}
	
	public Profile create(Integer userId, Profile profile) {
		
		Optional<User> result = userRepository.findById(userId);
		
		if(result.isPresent()) {
			profile.setUser(result.get());
			return profileRepository.save(profile);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id %d doesn't exists", userId));
		}
	}
}
