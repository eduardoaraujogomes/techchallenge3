package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantUpdateData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewUpdateData;
import br.com.fiap.techChallenge3.usecase.restaurant.UpdateRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.review.UpdateReviewUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateReviewController {
    private final UpdateReviewUseCase updateReviewUseCase;

    public UpdateReviewController(UpdateReviewUseCase updateReviewUseCase) {
        this.updateReviewUseCase = updateReviewUseCase;
    }

    @PutMapping("/review/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewPublicData updateReview(@PathVariable Long id, @Valid @RequestBody ReviewUpdateData updateData) throws ReviewNotFoundException {
        return new ReviewPublicData(updateReviewUseCase.execute(id,updateData));
    }

}
