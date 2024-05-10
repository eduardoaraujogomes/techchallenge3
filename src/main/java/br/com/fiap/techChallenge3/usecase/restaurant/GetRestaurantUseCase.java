package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public class GetRestaurantUseCase {

    private final RestaurantGateway restaurantGateway;

    public GetRestaurantUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public Restaurant execute(Long id) throws RestaurantNotFoundException {
        return this.restaurantGateway
                .findById(id)
                .orElseThrow(RestaurantNotFoundException::new);
    }
}
