package com.example.demo.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/users")
	public List<User> reteriveAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> reteriveUserOnId(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			EntityModel<User> userModel = EntityModel.of(user.get());
			WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).reteriveAllUsers());
			userModel.add(linkToUsers.withRel("all-users"));
			return userModel;
		} else {
			throw new UserNotFoundException("ID not found - " + id);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = userRepo.save(user);
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(uriLocation).build();
		// return newUser;
	}

	@DeleteMapping("/users/{id}")
	public void deleteuser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("ID not found for delete - " + id);
		}
		userRepo.deleteById(id);
	}
}
