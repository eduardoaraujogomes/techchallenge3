package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;

import java.util.List;

public class SearchReviewUseCase {

    private final ReviewGateway reviewGateway;

    public SearchReviewUseCase(ReviewGateway reviewGateway) {
        this.reviewGateway = reviewGateway;
    }

    public List <Review> execute() {
        return this.reviewGateway.findAll();
    }
}
