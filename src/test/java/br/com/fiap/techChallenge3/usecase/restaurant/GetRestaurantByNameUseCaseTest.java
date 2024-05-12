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

class GetRestaurantByNameUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private GetRestaurantByNameUseCase getRestaurantByNameUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        getRestaurantByNameUseCase = new GetRestaurantByNameUseCase(restaurantGateway);
    }

    @Test
    void shouldGetRestaurantByNameSuccessTest() throws RestaurantNotFoundException {

        String restaurantName = "The Best Of Recife";
        Restaurant expectedRestaurant = new Restaurant(restaurantName, "Recife", "Brasileira",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);

        when(restaurantGateway.findByName(restaurantName)).thenReturn(Optional.of(expectedRestaurant));

        Restaurant actualRestaurant = getRestaurantByNameUseCase.execute(restaurantName);

        assertEquals(expectedRestaurant, actualRestaurant);
        verify(restaurantGateway, times(1)).findByName(restaurantName);
    }

    @Test
    void shouldGetRestaurantByNameNotFoundTest() {

        String nonExistingRestaurantName = "The Best Of Recife not Inexistent";

        when(restaurantGateway.findByName(nonExistingRestaurantName)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> getRestaurantByNameUseCase.execute(nonExistingRestaurantName));
        verify(restaurantGateway, times(1)).findByName(nonExistingRestaurantName);
    }
}