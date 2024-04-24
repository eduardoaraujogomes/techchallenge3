package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantUpdateData;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateRestaurantUseCase {
    private final RestaurantGateway restaurantGateway;

    public UpdateRestaurantUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }

    public Restaurant execute(Long id, RestaurantUpdateData updateData) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantGateway.findById(id).orElseThrow(RestaurantNotFoundException::new);
        updatePropertyIfPresent(restaurant::setName, updateData::name);
        updatePropertyIfPresent(restaurant::setLocation, updateData::location);
        updatePropertyIfPresent(restaurant::setCuisineType, updateData::cuisineType);
        updateLocalTimeIfPresent(restaurant::setOpeningHours, updateData::openingHours);
        updateIntegerIfPresent(restaurant::setCapacity, updateData::capacity);
        return restaurant;
    }

    private void updatePropertyIfPresent(Consumer<String> setter, Supplier<String> valueSupplier) {
        Optional.ofNullable(valueSupplier.get())
                .ifPresent(setter);
    }
    private void updateLocalTimeIfPresent(Consumer<LocalTime> setter, Supplier<String> stringValue) {
        Optional.ofNullable(stringValue.get())
                .filter(s -> !s.isBlank())
                .map(LocalTime::parse)
                .ifPresent(setter);
    }

    private void updateIntegerIfPresent(Consumer<Integer> setter, Supplier<String> stringValue) {
        Optional.ofNullable(stringValue.get())
                .filter(s -> !s.isBlank())
                .map(Integer::valueOf)
                .ifPresent(setter);
    }
}
