package hu.elte.recipe.exceptions;

/**
 * The Class NoEnoughPropertyException.
 */
public class NoEnoughPropertyException extends RuntimeException {
    
  private static final long serialVersionUID = 7556721445116157473L;

  /**
   * Instantiates a new no enough property exception.
   *
   * @param s the s
   */
  public NoEnoughPropertyException(String s) {
    super(s);
  }
}
