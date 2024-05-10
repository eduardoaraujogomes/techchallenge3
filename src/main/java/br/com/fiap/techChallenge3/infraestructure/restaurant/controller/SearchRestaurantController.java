package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.SearchRestaurantUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchRestaurantController {
    private final SearchRestaurantUseCase searchRestaurantUseCase;

    public SearchRestaurantController(SearchRestaurantUseCase searchRestaurantUseCase) {
        this.searchRestaurantUseCase = searchRestaurantUseCase;
    }

    @GetMapping("/restaurants")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantPublicData> searchRestaurants() throws RestaurantNotFoundException {
        List<Restaurant> restaurants = this.searchRestaurantUseCase.execute();
        return restaurants.stream().map(RestaurantPublicData::new).toList();
    }
}
