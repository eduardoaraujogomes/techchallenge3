package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantUpdateData;
import com.fasterxml.jackson.annotation.JsonFormat;

public record RestaurantUpdateData(
        String name,
        String location,
        String cuisineType,
        @JsonFormat(pattern = "HH:mm")
        String openingHours,
        String capacity
) implements IRestaurantUpdateData {
}
