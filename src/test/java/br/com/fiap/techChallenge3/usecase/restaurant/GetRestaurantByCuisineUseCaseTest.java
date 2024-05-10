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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GetRestaurantByCuisineUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private GetRestaurantByCuisineUseCase getRestaurantByCuisineUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        getRestaurantByCuisineUseCase = new GetRestaurantByCuisineUseCase(restaurantGateway);
    }

    @Test
    void deveConsultarRestaurantByCuisineComSucesso() throws RestaurantNotFoundException {

        String cuisine = "Brasileira";
        Restaurant restaurant1 = new Restaurant("The Best Of Recife", "Recife", cuisine,
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        Restaurant restaurant2 = new Restaurant("The Best Of Belo Horizonte", "Belo Horizonte", "Mineira",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 70);
        List<Restaurant> expectedRestaurants = Arrays.asList(restaurant1, restaurant2);

        when(restaurantGateway.findByCuisine(cuisine)).thenReturn(expectedRestaurants);

        List<Restaurant> actualRestaurants = getRestaurantByCuisineUseCase.execute(cuisine);

        assertEquals(expectedRestaurants, actualRestaurants);
        verify(restaurantGateway, times(1)).findByCuisine(cuisine);
    }
}
