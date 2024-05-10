package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.usecase.review.dto.IReviewUpdateData;

public record ReviewUpdateData(
        Double rating,
        String comment
) implements IReviewUpdateData {
}
