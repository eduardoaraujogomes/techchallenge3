package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.usecase.review.dto.IReviewRegistrationData;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ReviewRegistrationData(
        @NotNull
        Long restaurantId,
        @NotNull
        Long userId,
        @NotNull
        Double rating,
        @NotNull
        String comment
) implements IReviewRegistrationData {

}
