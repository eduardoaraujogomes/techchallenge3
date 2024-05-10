package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.SearchRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.review.SearchReviewUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchReviewController {
    private final SearchReviewUseCase searchReviewUseCase;

    public SearchReviewController(SearchReviewUseCase searchReviewUseCase) {
        this.searchReviewUseCase = searchReviewUseCase;
    }

    @GetMapping("/review")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewPublicData> searchReview() throws ReviewNotFoundException {
        List<Review> review = this.searchReviewUseCase.execute();
        return review.stream().map(ReviewPublicData::new).toList();
    }
}
