package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewUpdateData;

import java.util.function.Consumer;

public class UpdateReviewUseCase {

    private final ReviewGateway reviewGateway;

    public UpdateReviewUseCase(ReviewGateway reviewGateway) {
        this.reviewGateway = reviewGateway;
    }

    public Review execute(Long id, ReviewUpdateData updateData) throws ReviewNotFoundException {

        Review review = reviewGateway.findById(id).orElseThrow(ReviewNotFoundException::new);

        updateReviewIfNotBlank(updateData.rating(), review::setRating);
        updateReviewIfNotBlank(updateData.comment(), review::setComment);

        reviewGateway.update(review);

        return review;
    }

    private <T> void updateReviewIfNotBlank(T value, Consumer<T> setter) {
        if (value != null && (!(value instanceof String) || !((String) value).isBlank())) {
            setter.accept(value);
        }
    }

}
