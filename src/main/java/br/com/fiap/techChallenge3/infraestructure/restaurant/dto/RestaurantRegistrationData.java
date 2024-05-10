package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantRegistrationData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

public record RestaurantRegistrationData(
        @NotNull
        String name,
        @NotNull
        String location,
        @NotNull
        String cuisineType,
        @NotNull
        @JsonFormat(pattern = "HH:mm")
        String openingHours,
        @NotNull
        Integer capacity
) implements IRestaurantRegistrationData {

}
