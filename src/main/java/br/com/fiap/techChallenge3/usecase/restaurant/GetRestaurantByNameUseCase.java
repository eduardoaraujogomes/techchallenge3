package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public class GetRestaurantByNameUseCase {

    private final RestaurantGateway restaurantGateway;

    public GetRestaurantByNameUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public Restaurant execute(String name) throws RestaurantNotFoundException {
        return this.restaurantGateway
                .findByName(name)
                .orElseThrow(RestaurantNotFoundException::new);
    }
}
