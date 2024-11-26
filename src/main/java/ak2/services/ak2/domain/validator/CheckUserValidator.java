package ak2.services.ak2.domain.validator;

import ak2.services.ak2.domain.annotations.CheckUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kotlin.text.Regex;

public class CheckUserValidator implements ConstraintValidator<CheckUsername, String> {

    private final Regex regex = new Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W)[\\S]+$");


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isBlank()) {
            overrideDefaultMessage("Please put username", context);
            return false;
        } else if (value.length() >= 10) {
            overrideDefaultMessage("have to be put more than or equal 10", context);
            return false;
        } else if (!regex.matches(value)) {
            overrideDefaultMessage("you must use upper and lower case and special characters and digit at least one", context);
            return false;
        }
        return true;
    }

    private void overrideDefaultMessage(String message, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
