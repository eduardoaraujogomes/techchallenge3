package br.com.fiap.techChallenge3.infraestructure.config.db.repository;

import br.com.fiap.techChallenge3.infraestructure.config.db.schema.CustomerSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerSchema, Long> {

    Optional<CustomerSchema> findByCpf(String cpf);

}
