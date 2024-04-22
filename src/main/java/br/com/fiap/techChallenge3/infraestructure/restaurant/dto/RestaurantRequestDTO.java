package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

public record RestaurantRequestDTO(String name,
                                   String location,
                                   String cuisineType,
                                   String openingHours,
                                   Integer capacity) {
}
