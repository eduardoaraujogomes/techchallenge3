package br.com.fiap.techChallenge3.entity.user.gateaway;

import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.entity.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    User create(User user);
    User update(User user);
    void delete(Long id);
    Optional<User> findById (User user);
    List<User> findAll();

}
