package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewUpdateData;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateReviewUseCase {

    private final ReviewGateway reviewGateway;

    public UpdateReviewUseCase(ReviewGateway reviewGateway) {
        this.reviewGateway = reviewGateway;
    }

    public Review execute(Long id, ReviewUpdateData updateData) throws ReviewNotFoundException {
        Review review = reviewGateway.findById(id).orElseThrow(ReviewNotFoundException::new);
        updateRestaurantIfPresent(review::setRestaurant, updateData::restaurant);
        updateLongIfPresent(review::setUserId, updateData::userId);
        updateDoubleIfPresent(review::setRating, updateData::rating);
        updatePropertyIfPresent(review::setComment, updateData::comment);
        return review;
    }

    private void updatePropertyIfPresent(Consumer <String> setter, Supplier <String> valueSupplier) {
        Optional.ofNullable(valueSupplier.get())
                .ifPresent(setter);
    }
    private void updateLongIfPresent(Consumer<Long> setter, Supplier<String> stringValue) {
        Optional.ofNullable(stringValue.get())
                .filter(s -> !s.isBlank())
                .ifPresent(setter);
    }

    private void updateDoubleIfPresent(Consumer<Double> setter, Supplier<String> stringValue) {
        Optional.ofNullable(stringValue.get())
                .filter(s -> !s.isBlank())
                .map(Integer::valueOf)
                .ifPresent(setter);
    }

    private void updateRestaurantIfPresent(Consumer<Restaurant> setter, Supplier<String> stringValue) {
        Optional.ofNullable(stringValue.get())
                .filter(s -> !s.isBlank())
                .map(Integer::valueOf)
                .ifPresent(setter);
    }
}
