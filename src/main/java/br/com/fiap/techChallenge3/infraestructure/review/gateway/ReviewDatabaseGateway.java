package br.com.fiap.techChallenge3.infraestructure.review.gateway;

import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReviewRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.ReviewSchema;
import java.util.List;
import java.util.Optional;

public class ReviewDatabaseGateway implements ReviewGateway {

    private final ReviewRepository reviewRepository;

    public ReviewDatabaseGateway(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(new ReviewSchema(review)).toReview();
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(new ReviewSchema(review)).toReview();
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository
                .findById(id)
                .map(ReviewSchema::toReview);
    }


    @Override
    public List<Review> findAll() {
        return reviewRepository
                .findAll()
                .stream()
                .map(ReviewSchema::toReview)
                .toList();
    }
}
