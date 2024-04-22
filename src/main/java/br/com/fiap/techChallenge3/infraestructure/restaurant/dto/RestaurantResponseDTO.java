package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;
import br.com.fiap.techChallenge3.entity.review.model.Review;

import java.util.List;

public record RestaurantResponseDTO(Long id,
                                    String name,
                                    String location,
                                    String cuisineType,
                                    String openingHours,
                                    Integer capacity,

                                    List<Review> reviews) {
}
