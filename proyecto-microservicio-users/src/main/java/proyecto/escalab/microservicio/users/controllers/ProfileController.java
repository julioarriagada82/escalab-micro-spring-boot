package proyecto.escalab.microservicio.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.escalab.microservicio.users.entities.Profile;
import proyecto.escalab.microservicio.users.services.ProfileService;

@RestController
@RequestMapping("/users/{userid}/profiles")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/{profileId}")
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<Profile> getById(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId) {
		return new ResponseEntity<Profile>(profileService.getByIdUserIdAndProfileId(userId, profileId), HttpStatus.OK);
	}

	@PostMapping
	//Metodo HTTP + Recurso -> Handler Methods
	public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId,  @RequestBody Profile profile) {
		return new ResponseEntity<Profile>(profileService.create(userId, profile), HttpStatus.CREATED);
	}
}
