package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

import java.util.List;

public class GetRestaurantByLocationUseCase {

    private final RestaurantGateway restaurantGateway;

    public GetRestaurantByLocationUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public List<Restaurant> execute(String name) throws RestaurantNotFoundException {
        return this.restaurantGateway.findByLocation(name);

    }
}
