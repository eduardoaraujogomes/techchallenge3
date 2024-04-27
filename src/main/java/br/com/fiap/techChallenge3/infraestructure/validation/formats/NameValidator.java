package br.com.fiap.techChallenge3.infraestructure.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class NameValidator implements ConstraintValidator<Name, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null || name.isBlank()) return true;

        //this regex validate the full name of a user, including the first, last name and accents. it will reject numbers.

        return name.matches("/\\b[A-Za-zÀ-ú][A-Za-zÀ-ú]+,?\\s[A-Za-zÀ-ú][A-Za-zÀ-ú]{2,19}\\b/gi");
    }
}
