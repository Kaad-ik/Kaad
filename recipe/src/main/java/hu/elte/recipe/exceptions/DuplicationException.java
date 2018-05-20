package hu.elte.recipe.exceptions;

/**
 * The Class DuplicationException.
 */
public class DuplicationException extends RuntimeException {

  private static final long serialVersionUID = 5042455957742131177L;

  /**
   * Instantiates a new duplication exception.
   *
   * @param s the s
   */
  public DuplicationException(String s) {
    super(s);
  }
}
