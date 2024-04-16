package br.com.fiap.techChallenge3.dto.review;

import br.com.fiap.techChallenge3.entities.Restaurant;

public record ReviewRequestDTO (Restaurant restaurant,
        Long userId,
        Double rating,
        String comment){
}
