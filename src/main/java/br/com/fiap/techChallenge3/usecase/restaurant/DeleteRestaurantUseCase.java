package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public class DeleteRestaurantUseCase {
    private final RestaurantGateway restaurantGateway;

    public DeleteRestaurantUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public Restaurant execute(Long id) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantGateway.findById(id).orElseThrow(RestaurantNotFoundException::new);
        restaurantGateway.delete(id);
        return restaurant;
    }
}
