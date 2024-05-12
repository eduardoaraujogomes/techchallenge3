package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.customer.DeleteCustomerUseCase;
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
    public void restaurants(@PathVariable Long id) throws RestaurantNotFoundException {
        deleteRestaurantUseCase.execute(id);
    }
}
