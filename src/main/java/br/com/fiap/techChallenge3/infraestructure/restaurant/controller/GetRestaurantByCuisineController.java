package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantByCuisineUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRestaurantByCuisineController {
    private final GetRestaurantByCuisineUseCase getRestaurantByCuisineUseCase;

    public GetRestaurantByCuisineController(GetRestaurantByCuisineUseCase getRestaurantByCuisineUseCase) {
        this.getRestaurantByCuisineUseCase = getRestaurantByCuisineUseCase;
    }

    @GetMapping("/restaurants/cuisine/{cuisine}")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantPublicData> getRestaurantByCuisine(@PathVariable String cuisine) throws RestaurantNotFoundException {
        return getRestaurantByCuisineUseCase.execute(cuisine).stream().map(RestaurantPublicData::new).toList();
    }

}
