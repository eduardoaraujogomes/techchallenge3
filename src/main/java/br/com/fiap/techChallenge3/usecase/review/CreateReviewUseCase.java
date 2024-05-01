package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewtRegistrationData;

public class CreateReviewUseCase {

    private final ReviewGateway reviewGateway;
    private final RestaurantGateway restaurantGateway;

    public CreateReviewUseCase(ReviewGateway reviewGateway, RestaurantGateway restaurantGateway) {
        this.reviewGateway = reviewGateway;
        this.restaurantGateway = restaurantGateway;
    }

    public Review execute(IReviewtRegistrationData registrationData) throws RestaurantNotFoundException{
        Restaurant restaurant = restaurantGateway.findById(registrationData.restaurantId()).orElseThrow(RestaurantNotFoundException::new);
        Review review = new Review(restaurant, registrationData.userId(), registrationData.rating(), registrationData.comment());
        return reviewGateway.create(review);
    }
}
