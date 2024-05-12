package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

import java.util.List;

public class GetRestaurantByCuisineUseCase {

    private final RestaurantGateway restaurantGateway;

    public GetRestaurantByCuisineUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public List<Restaurant> execute(String cuisine) throws RestaurantNotFoundException {
        return this.restaurantGateway.findByCuisine(cuisine);
    }

}
