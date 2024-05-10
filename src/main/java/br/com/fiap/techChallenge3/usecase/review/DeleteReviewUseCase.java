package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;

public class DeleteReviewUseCase {

    private final ReviewGateway reviewGateway;

    public DeleteReviewUseCase(ReviewGateway reviewGateway) {
        this.reviewGateway = reviewGateway;
    }

    public Review execute(Long id) throws ReviewNotFoundException {
        Review review = reviewGateway.findById(id).orElseThrow( ReviewNotFoundException::new);
        reviewGateway.delete(id);
        return review;
    }
}
