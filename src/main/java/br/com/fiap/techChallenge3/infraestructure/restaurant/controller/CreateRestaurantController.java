package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.usecase.restaurant.CreateRestaurantUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRestaurantController {
    private final CreateRestaurantUseCase createRestaurantUseCase;

    public CreateRestaurantController(CreateRestaurantUseCase createRestaurantUseCase) {
        this.createRestaurantUseCase = createRestaurantUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantPublicData createRestaurant(@Valid @RequestBody RestaurantRegistrationData restaurantData){
        return new RestaurantPublicData(createRestaurantUseCase.execute(restaurantData));
    }
}
