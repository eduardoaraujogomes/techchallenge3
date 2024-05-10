package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantCustomerData;

public record RestaurantCustomerData(
        String name,
        String location,
        String cuisine
) implements IRestaurantCustomerData {

        public RestaurantCustomerData(Restaurant restaurant) {
            this(
                    restaurant.getName(),
                    restaurant.getLocation(),
                    restaurant.getCuisine()
            );
        }
}
