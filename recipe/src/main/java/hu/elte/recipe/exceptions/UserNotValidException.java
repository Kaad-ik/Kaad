package hu.elte.recipe.exceptions;

public class UserNotValidException extends RuntimeException {
	
	private static final long serialVersionUID = -3039416768713382747L;

	public UserNotValidException() {
		super("Not a valid user.");
	}
}
