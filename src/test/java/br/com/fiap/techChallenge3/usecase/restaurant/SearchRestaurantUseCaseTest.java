package br.com.fiap.techChallenge3.usecase.restaurant;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SearchRestaurantUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private SearchRestaurantUseCase searchRestaurantUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        searchRestaurantUseCase = new SearchRestaurantUseCase(restaurantGateway);
    }

    @Test
    void searchRestaurantSuccessTest() {

        List<Restaurant> expectedRestaurants = Arrays.asList(
                new Restaurant("The Best Of Recife", "Recife", "Brasileira",
                        LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50),
                new Restaurant("The Best Of São Paulo", "Rio de Janeiro", "Carioca",
                        LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 70)
        );

        when(restaurantGateway.findAll()).thenReturn(expectedRestaurants);

        List<Restaurant> actualRestaurants = searchRestaurantUseCase.execute();

        assertEquals(expectedRestaurants, actualRestaurants);
        verify(restaurantGateway, times(1)).findAll();
    }
}