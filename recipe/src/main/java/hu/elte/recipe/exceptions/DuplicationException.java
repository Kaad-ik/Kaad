package hu.elte.recipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class DuplicationException.
 */
public class DuplicationException extends RuntimeException{

    /**
     * Instantiates a new duplication exception.
     *
     * @param s the s
     */
    public DuplicationException(String s) {
        super(s);
    }
}
