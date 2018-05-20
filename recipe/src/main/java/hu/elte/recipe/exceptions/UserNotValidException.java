package hu.elte.recipe.exceptions;

/**
 * The Class UserNotValidException.
 */
public class UserNotValidException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -3039416768713382747L;

  /**
   * Instantiates a new user not valid exception.
   */
  public UserNotValidException() {
    super("Not a valid user.");
  }
}
