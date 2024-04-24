package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantRegistrationData;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CreateRestaurantUseCase {

    private final RestaurantGateway restaurantGateway;

    public CreateRestaurantUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public Restaurant execute(IRestaurantRegistrationData registrationData){
        Restaurant restaurant = new Restaurant(registrationData.name(), registrationData.location(),registrationData.cuisineType(), LocalTime.parse(registrationData.openingHours(),DateTimeFormatter.ofPattern("HH:mm")), registrationData.capacity(), new ArrayList<>(), new ArrayList<>());
        return restaurantGateway.create(restaurant);
    }
}
