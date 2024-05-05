package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantPublicData;
import java.time.LocalTime;

public record RestaurantPublicData(
        Long id,
        String name,
        String location,
        String cuisineType,
        LocalTime openingHours,
        Integer capacity)

        implements IRestaurantPublicData {
    public RestaurantPublicData(Restaurant restaurant) {
        this(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLocation(),
                restaurant.getCuisine(),
                restaurant.getOpeningHours(),
                restaurant.getCapacity());
    }
}
