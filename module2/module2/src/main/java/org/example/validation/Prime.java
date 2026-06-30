package org.example.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrimeValidator.class)
public @interface Prime {
    // Default error message shown when validation fails
    String message() default "Value must be a prime number";

    // Required by Bean Validation spec - lets you group constraints
    Class<?>[] groups() default {};

    // Required by Bean Validation spec - lets you attach metadata to a constraint
    Class<? extends Payload>[] payload() default {};
}
