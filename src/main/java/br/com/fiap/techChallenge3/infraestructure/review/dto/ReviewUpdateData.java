package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantUpdateData;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewUpdateData;
import com.fasterxml.jackson.annotation.JsonFormat;

public record ReviewUpdateData(
        Restaurant restaurant,
        Long userId,
        Double rating,
        String comment
) implements IReviewUpdateData {
}
