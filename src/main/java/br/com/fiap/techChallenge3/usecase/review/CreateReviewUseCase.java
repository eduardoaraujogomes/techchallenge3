package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewRegistrationData;

public class CreateReviewUseCase {

    private final ReviewGateway reviewGateway;
    private final RestaurantGateway restaurantGateway;

    private final CustomerGateway customerGateway;

    public CreateReviewUseCase(ReviewGateway reviewGateway, RestaurantGateway restaurantGateway, CustomerGateway customerGateway) {
        this.reviewGateway = reviewGateway;
        this.restaurantGateway = restaurantGateway;
        this.customerGateway = customerGateway;
    }

    public Review execute(IReviewRegistrationData registrationData) throws RestaurantNotFoundException, CustomerNotFoundException {
        Restaurant restaurant = restaurantGateway.findById(registrationData.restaurantId()).orElseThrow(RestaurantNotFoundException::new);
        Customer customer = customerGateway.findById(registrationData.userId()).orElseThrow(CustomerNotFoundException::new);
        Review review = new Review(restaurant, customer, registrationData.rating(), registrationData.comment());
        return reviewGateway.create(review);
    }
}
