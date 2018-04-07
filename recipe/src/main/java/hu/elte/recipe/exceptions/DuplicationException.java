package hu.elte.recipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DuplicationException extends RuntimeException{

    public DuplicationException(String s) {
        super(s);
    }
}
