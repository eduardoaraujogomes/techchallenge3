package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewPublicData;

import java.io.Serializable;


public record ReviewPublicData(
        Long id,
        Restaurant restaurant,
        Long userId,
        Double rating,
        String comment) implements IReviewPublicData {
    public ReviewPublicData(Review review){
        this( (Long) review.getId(),
                review.getRestaurant(),
                review.getUserId(),
                review.getRating(),
                review.getComment()
        );
    }
}
