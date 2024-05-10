package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantCustomerData;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewCustomerData;

public record ReviewCustomerData(
        Long id,
        String comment,
        Double rating,
        RestaurantCustomerData restaurant
) implements IReviewCustomerData {

    public ReviewCustomerData(Review review) {
        this(
                review.getId(),
                review.getComment(),
                review.getRating(),
                new RestaurantCustomerData(review.getRestaurant())
        );
    }
}
