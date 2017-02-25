package masterSpringMvc.error;

public class DuplicateEntityFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DuplicateEntityFoundException(String message) {
		super(message);
	}
	
	public DuplicateEntityFoundException (String message, Throwable cause){
		super(message, cause);
	}

}
