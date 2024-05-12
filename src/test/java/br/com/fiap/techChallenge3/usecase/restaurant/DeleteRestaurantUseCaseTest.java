package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DeleteRestaurantUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private DeleteRestaurantUseCase deleteRestaurantUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        deleteRestaurantUseCase = new DeleteRestaurantUseCase(restaurantGateway);
    }


    @Test
    void shouldDeleteRestaurantSucessTest() throws RestaurantNotFoundException {

        long restaurantId = 1L;
        Restaurant restaurant = new Restaurant("The Best Of Recife", "Recife", "Brasileira",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        restaurant.setId(restaurantId);

        when(restaurantGateway.findById(restaurantId)).thenReturn(Optional.of(restaurant));

        deleteRestaurantUseCase.execute(restaurantId);

        verify(restaurantGateway, times(1)).findById(restaurantId);
        verify(restaurantGateway, times(1)).delete(restaurantId);
    }


    @Test
    void shouldExceptionRestaurantNotFoundTest() {

        long nonExistingRestaurantId = 2L;

        when(restaurantGateway.findById(nonExistingRestaurantId)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> deleteRestaurantUseCase.execute(nonExistingRestaurantId));
    }
}
