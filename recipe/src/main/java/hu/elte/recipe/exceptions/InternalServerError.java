package hu.elte.recipe.exceptions;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String s) {
        super(s);
    }
}
