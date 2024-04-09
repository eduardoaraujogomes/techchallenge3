package br.com.fiap.techChallenge3.repositories;

import br.com.fiap.techChallenge3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
