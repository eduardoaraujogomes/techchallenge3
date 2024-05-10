package br.com.fiap.techChallenge3.entity.review.gateway;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewGateway {
    Review create(Review review);
    Review update(Review review);
    void delete(Long id);
    Optional<Review> findById (Long id);
    List<Review> findAll();

}
