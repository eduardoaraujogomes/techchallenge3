package br.com.fiap.techChallenge3.usecase.restaurant.dto;

import br.com.fiap.techChallenge3.usecase.review.dto.IReviewPublicData;

import java.time.LocalTime;
import java.util.List;

public interface IRestaurantPublicData {
    Long id();
    String name();
    String location();
    String cuisineType();
    LocalTime openingHours();
    Integer capacity();
    List <IReviewPublicData> reviews();
    List<IReservationPublicData> reservations();


}
