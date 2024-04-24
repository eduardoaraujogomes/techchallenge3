package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewtRegistrationData;

public class CreateReviewUseCase {

    private final ReviewGateway reviewGateway;

    public CreateReviewUseCase(ReviewGateway reviewGateway) {
        this.reviewGateway = reviewGateway;
    }

    public Review execute(IReviewtRegistrationData registrationData){
        Review review = new Review(registrationData.restaurant(), registrationData.userId(),registrationData.rating(), registrationData.comment());
        return reviewGateway.create(review);
    }
}
