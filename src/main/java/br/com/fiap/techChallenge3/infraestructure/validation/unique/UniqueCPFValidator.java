package br.com.fiap.techChallenge3.infraestructure.validation.unique;

import static java.util.Objects.nonNull;

import br.com.fiap.techChallenge3.infraestructure.config.db.repository.CustomerRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.CustomerSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

    private final CustomerRepository repository;

    public UniqueCPFValidator(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (nonNull(repository)) {
            Optional<CustomerSchema> customer = repository.findByCpf(cpf);
            return customer.isEmpty();
        }

        return true;
    }
}
