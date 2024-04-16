package br.com.fiap.techChallenge3.dto.review;

import br.com.fiap.techChallenge3.entities.Restaurant;

public record ReviewResponseDTO(Long id,
                                Restaurant restaurant,
                                Long userId,
                                Double rating,
                                String comment) {
}
