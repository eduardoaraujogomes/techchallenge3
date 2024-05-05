package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerPublicData;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewPublicData;


public record ReviewPublicData(
        Long id,
        RestaurantPublicData restaurant,
        CustomerPublicData customer,
        Double rating,
        String comment) implements IReviewPublicData {
    public ReviewPublicData(Review review) {
        this(review.getId(),
                new RestaurantPublicData(review.getRestaurant()),
                new CustomerPublicData(review.getCustomer()),
                review.getRating(),
                review.getComment()
        );
    }
}
