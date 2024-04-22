package br.com.fiap.techChallenge3.infraestructure.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public record ReviewRequestDTO (Restaurant restaurant,
        Long userId,
        Double rating,
        String comment){
}
