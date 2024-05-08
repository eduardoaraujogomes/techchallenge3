package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantByLocationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRestaurantByLocationController {
    private final GetRestaurantByLocationUseCase getRestaurantByLocationUseCase;

    public GetRestaurantByLocationController(GetRestaurantByLocationUseCase getRestaurantByLocationUseCase) {
        this.getRestaurantByLocationUseCase = getRestaurantByLocationUseCase;
    }

    @GetMapping("/restaurants/location/{location}")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantPublicData> getRestaurantByLocation(@PathVariable String location) throws RestaurantNotFoundException {
        return getRestaurantByLocationUseCase.execute(location).stream().map(RestaurantPublicData::new).toList();
    }

}
