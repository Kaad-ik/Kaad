package hu.elte.recipe.exceptions;

/**
 * The Class InternalServerError.
 */
public class InternalServerError extends RuntimeException {
    
  private static final long serialVersionUID = -4598515170914212578L;

  /**
   * Instantiates a new internal server error.
   *
   * @param s the s
   */
  public InternalServerError(String s) {
    super(s);
  }
}
