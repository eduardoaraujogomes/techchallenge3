package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
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

public class GetReviewUseCaseTest {

    private ReviewGateway reviewGateway;
    private GetReviewUseCase getReviewUseCase;

    @BeforeEach
    public void setUp() {
        reviewGateway = mock(ReviewGateway.class);
        getReviewUseCase = new GetReviewUseCase(reviewGateway);
    }

    @Test
    public void deveBuscarReviewComSucessoTest() {

        Restaurant restaurant = new Restaurant(
                "The Best Of Recife", "Recife", "Brasileira", LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        Customer customer = new Customer(
                "augusto.junior", "augusto@junior.com", "123password", "augusto@junior.com", "46339814042", "1132659848");
        Review review = new Review(restaurant, customer, 10.00, "comentario");
        review.setId(1L);
        when(reviewGateway.findById(review.getId())).thenReturn(Optional.of(review));

        var result = getReviewUseCase.execute(review.getId());

        assertEquals(result, review);
        verify(reviewGateway, times(1)).findById(any(Long.class));

    }

    @Test
    public void deveBuscarReviewSemSucessoTest() {

        Long ReviewID = 1L;
        when(reviewGateway.findById(ReviewID)).thenReturn(Optional.empty());

        assertThrows(ReviewNotFoundException.class, () -> {
            getReviewUseCase.execute(ReviewID);
        });
        verify(reviewGateway, times(1)).findById(any(Long.class));

    }

}