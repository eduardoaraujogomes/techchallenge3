package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

import java.util.List;

public class SearchRestaurantUseCase {
    private final RestaurantGateway restaurantGateway;

    public SearchRestaurantUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public List<Restaurant> execute() {
        return this.restaurantGateway.findAll();
    }
}
