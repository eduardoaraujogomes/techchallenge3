package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.DeleteRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.review.DeleteReviewUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteReviewController {
    private final DeleteReviewUseCase deleteReviewUseCase;

    public DeleteReviewController(DeleteReviewUseCase deleteReviewUseCase) {
        this.deleteReviewUseCase = deleteReviewUseCase;
    }

    @DeleteMapping("/review/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewPublicData deleteReview(@PathVariable Long id) throws ReviewNotFoundException {
        return new ReviewPublicData(deleteReviewUseCase.execute(id));
    }
}
