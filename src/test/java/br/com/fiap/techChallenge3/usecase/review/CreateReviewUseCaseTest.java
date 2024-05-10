package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.usecase.review.dto.IReviewRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateReviewUseCaseTest {

    private ReviewGateway reviewGateway;
    private RestaurantGateway restaurantGateway;
    private CustomerGateway customerGateway;
    private CreateReviewUseCase createReviewUseCase;

    @BeforeEach
    public void setUp() {
        reviewGateway = mock(ReviewGateway.class);
        restaurantGateway = mock(RestaurantGateway.class);
        customerGateway = mock(CustomerGateway.class);
        createReviewUseCase = new CreateReviewUseCase(reviewGateway, restaurantGateway, customerGateway);
    }

    @Test
    public void deveCriarReviewComSucessoTest() {

        Restaurant restaurant = new Restaurant(
                "The Best Of Recife", "Recife", "Brasileira", LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        when(restaurantGateway.findById(any())).thenReturn(Optional.of(restaurant));
        Customer customer = new Customer(
                "augusto.junior", "augusto@junior.com", "123password", "augusto@junior.com", "46339814042", "1132659848");
        when(customerGateway.findById(any())).thenReturn(Optional.of(customer));
        IReviewRegistrationData registrationData = mock(IReviewRegistrationData.class);
        when(registrationData.restaurantId()).thenReturn(1L);
        when(registrationData.userId()).thenReturn(2L);
        when(registrationData.rating()).thenReturn(10.0);
        when(registrationData.comment()).thenReturn("comentario");
        Review review = new Review(restaurant, customer, 10.00, "comentario");
        when(reviewGateway.create(any())).thenReturn(review);

        Review result = createReviewUseCase.execute(registrationData);

        assertEquals(result.getRestaurant(), restaurant);
        assertEquals(result.getCustomer(), customer);
        assertEquals(result.getRating(), 10.0);
        assertEquals(result.getComment(), "comentario");
        verify(reviewGateway, times(1)).create(any(Review.class));

    }

    @Test
    public void deveCriarReviewSemSucessoTest() {

        Restaurant restaurant = new Restaurant(
                "The Best Of Recife", "Recife", "Brasileira", LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        Customer customer = new Customer(
                "augusto.junior", "augusto@junior.com", "123password", "augusto@junior.com", "46339814042", "1132659848");
        IReviewRegistrationData registrationData = mock(IReviewRegistrationData.class);
        Review review = new Review(restaurant, customer, 10.00, "comentario");
        when(reviewGateway.create(any())).thenReturn(review);

        assertThrows(RestaurantNotFoundException.class, () -> {
            Review result = createReviewUseCase.execute(registrationData);
        });
        verify(reviewGateway, times(0)).create(any(Review.class));

    }

}