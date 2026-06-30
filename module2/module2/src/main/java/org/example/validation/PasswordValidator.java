package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile(".*[!@#$%^&*()\\-_=+\\[\\]{}|;:'\",.<>/?].*");
    private static final int MIN_LENGTH = 10;


    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return true;   // let @NotNull / @NotBlank own this responsibility
        }

        boolean hasUppercase = UPPERCASE_PATTERN.matcher(password).matches();
        boolean hasLowercase = LOWERCASE_PATTERN.matcher(password).matches();
        boolean hasSpecialChar = SPECIAL_CHAR_PATTERN.matcher(password).matches();
        boolean hasMinLength = password.length() >= MIN_LENGTH;

        if (hasUppercase && hasLowercase && hasSpecialChar && hasMinLength) {
            return true;
        }

        // Otherwise, build a SPECIFIC error message telling the user exactly what's missing
        context.disableDefaultConstraintViolation();   // turn off the generic default message

        StringBuilder message = new StringBuilder("Password must contain: ");
        if (!hasUppercase) message.append("an uppercase letter, ");
        if (!hasLowercase) message.append("a lowercase letter, ");
        if (!hasSpecialChar) message.append("a special character, ");
        if (!hasMinLength) message.append("minimum 10 characters, ");

        // remove trailing ", "
        String finalMessage = message.substring(0, message.length() - 2);

        context.buildConstraintViolationWithTemplate(finalMessage)
                .addConstraintViolation();

        return false;

    }
}
