package br.com.fiap.techChallenge3.usecase.review;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.exception.ReviewNotFoundException;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewUpdateData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateReviewUseCaseTest {

    private ReviewGateway reviewGateway;
    private UpdateReviewUseCase updateReviewUseCase;

    @BeforeEach
    public void setUp() {
        reviewGateway = mock(ReviewGateway.class);
        updateReviewUseCase = new UpdateReviewUseCase(reviewGateway);
    }

    @Test
    public void deveAtualizarReviewComSucessoTest() {

        Restaurant restaurant = new Restaurant(
                "The Best Of Recife", "Recife", "Brasileira", LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        Customer customer = new Customer(
                "augusto.junior", "augusto@junior.com", "123password", "augusto@junior.com", "46339814042", "1132659848");
        Review review = new Review(restaurant, customer, 10.00, "comentario");
        review.setId(1L);
        ReviewUpdateData updateData = new ReviewUpdateData(9.0, "comentario alterado");
        when(reviewGateway.findById(review.getId())).thenReturn(Optional.of(review));

        var result = updateReviewUseCase.execute(review.getId(), updateData);

        assertEquals(result.getRating(), updateData.rating());
        assertEquals(result.getComment(), updateData.comment());
        verify(reviewGateway, times(1)).update(any(Review.class));

    }

    @Test
    public void deveAtualizarReviewSemSucessoTest() {

        Long ReviewID = 1L;
        ReviewUpdateData updateData = new ReviewUpdateData(9.0, "comentario alterado");
        when(reviewGateway.findById(ReviewID)).thenReturn(Optional.empty());

        assertThrows(ReviewNotFoundException.class, () -> {
            updateReviewUseCase.execute(ReviewID, updateData);
        });
        verify(reviewGateway, times(0)).update(any(Review.class));

    }

}