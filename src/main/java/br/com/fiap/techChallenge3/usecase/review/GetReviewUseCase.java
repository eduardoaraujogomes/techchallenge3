package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;

public class GetReviewUseCase {

    private final ReviewGateway reviewGateway;

    public GetReviewUseCase(ReviewGateway reviewGateway) {
        this.reviewGateway = reviewGateway;
    }

    public Review execute(Long id) throws ReviewNotFoundException {
        return this.reviewGateway
                .findById(id)
                .orElseThrow(ReviewNotFoundException::new);
    }
}
