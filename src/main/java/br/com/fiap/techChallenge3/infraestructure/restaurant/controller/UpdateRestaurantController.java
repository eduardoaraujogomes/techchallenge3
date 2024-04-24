package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantUpdateData;
import br.com.fiap.techChallenge3.usecase.restaurant.UpdateRestaurantUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateRestaurantController {
    private final UpdateRestaurantUseCase updateRestaurantUseCase;

    public UpdateRestaurantController(UpdateRestaurantUseCase updateRestaurantUseCase) {
        this.updateRestaurantUseCase = updateRestaurantUseCase;
    }

    @PutMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantPublicData updateRestaurant(@PathVariable Long id, @Valid @RequestBody RestaurantUpdateData updateData) throws RestaurantNotFoundException {
        return new RestaurantPublicData(updateRestaurantUseCase.execute(id,updateData));
    }

}
