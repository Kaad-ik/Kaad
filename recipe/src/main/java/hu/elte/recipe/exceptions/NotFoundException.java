package hu.elte.recipe.exceptions;

/**
 * The Class NotFoundException.
 */
public class NotFoundException extends RuntimeException {
    
  private static final long serialVersionUID = 5732052834619189983L;

  /**
   * Instantiates a new not found exception.
   *
   * @param s the s
   */
  public NotFoundException(String s) {
    super(s);
  }
}
