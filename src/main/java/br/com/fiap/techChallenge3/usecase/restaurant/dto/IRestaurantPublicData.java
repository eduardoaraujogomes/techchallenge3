package br.com.fiap.techChallenge3.usecase.restaurant.dto;

import java.time.LocalTime;

public interface IRestaurantPublicData {
    Long id();

    String name();

    String location();

    String cuisineType();

    LocalTime openingHours();

    Integer capacity();


}
