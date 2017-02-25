package masterSpringMvc.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import masterSpringMvc.error.DuplicateEntityFoundException;
import masterSpringMvc.error.EntityNotFoundException;

@RestController
@RequestMapping("/api")
//@Secured("ROLE_ADMIN")
public class UserApiController {

	private UserRepository userRepository;

	@Autowired
	public UserApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> findall() {
		return userRepository.finaAll();
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) throws DuplicateEntityFoundException {
		User saved = userRepository.save(user);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{email}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User user)
			throws EntityNotFoundException {
		User saved = userRepository.update(email, user);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable String email) throws EntityNotFoundException {
		userRepository.delete(email);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable String email) throws EntityNotFoundException {
		User findOne = userRepository.findOne(email);
		return new ResponseEntity<>(findOne, HttpStatus.OK);
	}

}
