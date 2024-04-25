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
    private void updateLongIfPresent(Consumer<Long> setter, Supplier<Long> longValue) {
        Optional.ofNullable(longValue.get())
                .map(String::valueOf)
                .filter(s -> !s.isBlank())
                .map(Long::valueOf)
                .ifPresent(setter);
    }

    private void updateDoubleIfPresent(Consumer<Double> setter, Supplier<Double> doubleValue) {
        Optional.ofNullable(doubleValue.get())
                .map(String::valueOf)
                .filter(s -> !s.isBlank())
                .map(Double::valueOf)
                .ifPresent(setter);
    }

    private void updateRestaurantIfPresent(Consumer<Restaurant> setter, Supplier<Restaurant> restaurantValue) {
        Optional.ofNullable(restaurantValue.get())
                .ifPresent(setter);
    }

}
