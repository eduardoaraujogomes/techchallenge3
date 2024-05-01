package br.com.fiap.techChallenge3.infraestructure.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            return true;
        }

        // regex for validate the brazilian phone number format

        return phoneNumber.matches("^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$");
    }

}
