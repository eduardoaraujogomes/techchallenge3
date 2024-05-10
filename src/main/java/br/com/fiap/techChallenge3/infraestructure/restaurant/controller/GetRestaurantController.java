package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRestaurantController {
    private final GetRestaurantUseCase getRestaurantUseCase;

    public GetRestaurantController(GetRestaurantUseCase getRestaurantUseCase) {
        this.getRestaurantUseCase = getRestaurantUseCase;
    }

    @GetMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantPublicData getRestaurant(@PathVariable Long id) throws RestaurantNotFoundException {
        return new RestaurantPublicData(getRestaurantUseCase.execute(id));
    }

}
