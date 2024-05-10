package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.review.GetReviewUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetReviewController {
    private final GetReviewUseCase getReviewUseCase;

    public GetReviewController(GetReviewUseCase getReviewUseCase) {
        this.getReviewUseCase = getReviewUseCase;
    }

    @GetMapping("/review/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewPublicData getReview(@PathVariable Long id) throws ReviewNotFoundException {
        return new ReviewPublicData(getReviewUseCase.execute(id));
    }

}
