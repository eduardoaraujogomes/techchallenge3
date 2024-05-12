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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GetRestaurantUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private GetRestaurantUseCase getRestaurantUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        getRestaurantUseCase = new GetRestaurantUseCase(restaurantGateway);
    }

    @Test
    void shouldGetRestaurantByIdSuccessTest() throws RestaurantNotFoundException {

        long restaurantId = 1L;
        Restaurant expectedRestaurant = new Restaurant("The Best Of Recife", "Recife", "Brasileira",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);

        when(restaurantGateway.findById(restaurantId)).thenReturn(Optional.of(expectedRestaurant));

        Restaurant actualRestaurant = getRestaurantUseCase.execute(restaurantId);

        assertEquals(expectedRestaurant, actualRestaurant);
        verify(restaurantGateway, times(1)).findById(restaurantId);
    }

    @Test
    void shouldGetRestaurantByIdNotFoundTest() {

        long nonExistingRestaurantId = 2L;

        when(restaurantGateway.findById(nonExistingRestaurantId)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> getRestaurantUseCase.execute(nonExistingRestaurantId));
        verify(restaurantGateway, times(1)).findById(nonExistingRestaurantId);
    }
}