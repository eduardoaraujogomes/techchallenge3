package br.com.fiap.techChallenge3.dto.restaurant;
import br.com.fiap.techChallenge3.dto.review.ReviewResponseDTO;
import br.com.fiap.techChallenge3.entities.Review;

import java.util.List;

public record RestaurantResponseDTO(Long id,
                                    String name,
                                    String location,
                                    String cuisineType,
                                    String openingHours,
                                    Integer capacity,

                                    List<Review> reviews) {
}
