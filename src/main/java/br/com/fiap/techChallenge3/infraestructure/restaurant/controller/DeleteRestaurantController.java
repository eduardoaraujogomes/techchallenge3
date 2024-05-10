package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.DeleteRestaurantUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteRestaurantController {
    private final DeleteRestaurantUseCase deleteRestaurantUseCase;

    public DeleteRestaurantController(DeleteRestaurantUseCase deleteRestaurantUseCase) {
        this.deleteRestaurantUseCase = deleteRestaurantUseCase;
    }

    @DeleteMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantPublicData deleteRestaurant(@PathVariable Long id) throws RestaurantNotFoundException {
        return new RestaurantPublicData(deleteRestaurantUseCase.execute(id));
    }
}
