package br.com.fiap.techChallenge3.infraestructure.validation.unique;

import static java.util.Objects.nonNull;

import br.com.fiap.techChallenge3.infraestructure.config.db.repository.UserRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.UserSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository repository;

    public UniqueUsernameValidator(final UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (nonNull(repository)) {
            final Optional<UserSchema> user = repository.findByUsername(value);
            return user.isEmpty();
        }
        return true;
    }
}
