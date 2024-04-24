package br.com.fiap.techChallenge3.infraestructure.user.validation.unique;

import static java.util.Objects.nonNull;

import br.com.fiap.techChallenge3.infraestructure.config.db.repository.UserRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.UserSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository repository;

    public UniqueEmailValidator(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {
        if (nonNull(repository)) {
            final Optional<UserSchema> user = repository.findByEmail(email);
            return user.isEmpty();
        }
        return true;
    }
}
