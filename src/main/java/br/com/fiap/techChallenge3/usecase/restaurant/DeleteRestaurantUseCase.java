package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public class DeleteRestaurantUseCase {
    private final RestaurantGateway restaurantGateway;

    public DeleteRestaurantUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public void  execute(final Long id) {
        Restaurant restaurant = restaurantGateway.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        restaurantGateway.delete(restaurant.getId());
    }
}
