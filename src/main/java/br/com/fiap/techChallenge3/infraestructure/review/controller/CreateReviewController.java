package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewRegistrationData;
import br.com.fiap.techChallenge3.usecase.review.CreateReviewUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateReviewController {
    private final CreateReviewUseCase createReviewUseCase;

    public CreateReviewController(CreateReviewUseCase createReviewUseCase) {
        this.createReviewUseCase = createReviewUseCase;
    }

    @PostMapping("/review")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewPublicData createReview(@Valid @RequestBody ReviewRegistrationData reviewData) {
        return new ReviewPublicData(createReviewUseCase.execute(reviewData));
    }
}
