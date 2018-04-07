package hu.elte.recipe.exceptions;

public class NoEnoughPropertyException extends RuntimeException {
    public NoEnoughPropertyException(String s) {
        super(s);
    }
}
