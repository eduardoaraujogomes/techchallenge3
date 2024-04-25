package br.com.fiap.techChallenge3.usecase.restaurant.dto;

import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;

import java.time.LocalTime;
import java.util.List;

public interface IRestaurantPublicData {
    Long id();
    String name();
    String location();
    String cuisineType();
    LocalTime openingHours();
    Integer capacity();
    List <ReviewPublicData> reviews();
    //List<IReservationPublicData> reservations();


}
