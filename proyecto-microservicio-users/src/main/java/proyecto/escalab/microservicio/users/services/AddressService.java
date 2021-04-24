package proyecto.escalab.microservicio.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import proyecto.escalab.microservicio.users.entities.Address;
import proyecto.escalab.microservicio.users.entities.Profile;
import proyecto.escalab.microservicio.users.entities.User;
import proyecto.escalab.microservicio.users.repositories.AddressRepository;
import proyecto.escalab.microservicio.users.repositories.ProfileRepository;
import proyecto.escalab.microservicio.users.repositories.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	public List<Address> findAddressesByProfileIdAndUserId(Integer userId, Integer profileId) {
		return addressRepository.findByProfileId(userId, profileId);
	}
	
	public Address createAddress(Integer userId, Integer profileId,  Address address) {
		
		Optional<Profile> result = profileRepository.getByIdUserAndProfileId(userId, profileId);
		
		if(result.isPresent()) {
			address.setProfile(result.get());
			return addressRepository.save(address);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile id %d and User id %d doesn't exists", profileId, userId));
		}
		
	}
}
