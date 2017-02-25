package masterSpringMvc.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionMapper {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity could not be found")
	public void handleNotFound() {
	}
	
	@ExceptionHandler(DuplicateEntityFoundException.class)
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Entity alrady exists.")
	public void duplicateEntity(){
		
	}
	
}
