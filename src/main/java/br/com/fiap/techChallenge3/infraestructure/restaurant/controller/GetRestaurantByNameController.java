package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantByNameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRestaurantByNameController {
    private final GetRestaurantByNameUseCase getRestaurantByNameUseCase;

    public GetRestaurantByNameController(GetRestaurantByNameUseCase getRestaurantByNameUseCase) {
        this.getRestaurantByNameUseCase = getRestaurantByNameUseCase;
    }

    @GetMapping("/restaurants/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantPublicData getRestaurantByName(@PathVariable String name) throws RestaurantNotFoundException {
        return new RestaurantPublicData(getRestaurantByNameUseCase.execute(name));
    }

}
