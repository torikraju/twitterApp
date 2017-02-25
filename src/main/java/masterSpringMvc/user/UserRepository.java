package masterSpringMvc.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import masterSpringMvc.error.DuplicateEntityFoundException;
import masterSpringMvc.error.EntityNotFoundException;

@Repository
public class UserRepository {

	private final Map<String, User> userMap = new ConcurrentHashMap<>();

	public User update(String email, User user) throws EntityNotFoundException {

		if (!exists(email)) {
			throw new EntityNotFoundException("User " + email + " not found");
		}
		user.setEmail(email);
		return userMap.put(email, user);

	}
	
	public User save(User user) throws DuplicateEntityFoundException{
		if (exists(user.getEmail())) {
			throw new DuplicateEntityFoundException("User "+user.getEmail()+" alrady exists.");
		}
		return userMap.put(user.getEmail(), user);
	}
	
	public User findOne(String email) throws EntityNotFoundException{
		if (!exists(email)) {
			throw new EntityNotFoundException("User " + email + " not found");
		}
		return userMap.get(email);
	}

	public List<User> finaAll() {
		return new ArrayList<>(userMap.values());
	}

	public void delete(String email) throws EntityNotFoundException {
		if (!exists(email)) {
			throw new EntityNotFoundException("User " + email + " not found");
		}
		userMap.remove(email);
	}

	public boolean exists(String email) {
		return userMap.containsKey(email);
	}

}
