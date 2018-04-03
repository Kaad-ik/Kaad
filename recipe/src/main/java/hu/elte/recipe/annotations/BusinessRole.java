package hu.elte.recipe.annotations;

import hu.elte.recipe.entities.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by doma on 2017.10.28..
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BusinessRole {
    Role[] value() default {Role.GUEST};
}
