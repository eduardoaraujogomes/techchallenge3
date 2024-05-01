package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewUpdateData;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewtRegistrationData;
import jakarta.validation.constraints.NotNull;

public record ReviewRegistrationData(
        @NotNull
        Long restaurantId,
        @NotNull
        Long userId,
        @NotNull
        Double rating,
        @NotNull
        String comment
) implements IReviewtRegistrationData {

}
