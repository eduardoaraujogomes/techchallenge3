package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public record ReviewResponseDTO(Long id,
                                Restaurant restaurant,
                                Long userId,
                                Double rating,
                                String comment) {
}
