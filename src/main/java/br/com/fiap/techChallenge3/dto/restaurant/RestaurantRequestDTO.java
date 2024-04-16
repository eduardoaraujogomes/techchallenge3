package br.com.fiap.techChallenge3.dto.restaurant;

public record RestaurantRequestDTO(String name,
                                   String location,
                                   String cuisineType,
                                   String openingHours,
                                   Integer capacity) {
}
