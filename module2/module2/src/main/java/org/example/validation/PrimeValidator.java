package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<Prime,Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        // Let @NotNull handle null-checking separately;
        // a validator should not fail on null unless it owns that responsibility
        if (value == null) {
            return true;
        }

        return isPrime(value);
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;   // 0, 1, and negatives are not prime
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
