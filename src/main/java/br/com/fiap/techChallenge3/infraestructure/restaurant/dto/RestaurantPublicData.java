package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantPublicData;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public record RestaurantPublicData(
        Long id,
        String name,
        String location,
        String cuisineType,
        LocalTime openingHours,
        Integer capacity,
        List<ReviewPublicData> reviews)
        //List<ReservationPublicData> reservations)
        implements IRestaurantPublicData {
    public RestaurantPublicData(Restaurant restaurant){
        this(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLocation(),
                restaurant.getCuisineType(),
                restaurant.getOpeningHours(),
                restaurant.getCapacity(),
                new List <ReviewPublicData>(restaurant.getReviews())
                //new List<ReservationPublicData>(restaurant.getReservations())
        );
    }
}
