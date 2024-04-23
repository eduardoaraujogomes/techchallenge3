package br.com.fiap.techChallenge3.usecase.restaurant.dto;

public interface IRestaurantRegistrationData {
    String name();

    String location();

    String cuisineType();

    String openingHours();

    Integer capacity();
}
