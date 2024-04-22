package br.com.fiap.techChallenge3.infraestructure.config.db.repository;

import br.com.fiap.techChallenge3.entity.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
