package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantRegistrationData;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewUpdateData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

public record RevewRegistrationData(
        @NotNull
        Restaurant restaurant,
        @NotNull
        Long userId,
        @NotNull
        Double rating,
        @NotNull
        String comment
) implements IReviewUpdateData {

}
