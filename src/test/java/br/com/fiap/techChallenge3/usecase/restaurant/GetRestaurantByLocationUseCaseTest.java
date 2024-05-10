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
import static org.mockito.Mockito.*;

class GetRestaurantByLocationUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private GetRestaurantByLocationUseCase getRestaurantByLocationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        getRestaurantByLocationUseCase = new GetRestaurantByLocationUseCase(restaurantGateway);
    }

    @Test
    void deveConsultarRestaurantByLocationComSucesso() throws RestaurantNotFoundException {

        String location = "São Paulo";
        Restaurant restaurant1 = new Restaurant("The Best Of Recife", "Recife", "Brasileira",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        Restaurant restaurant2 = new Restaurant("The Best Of São Paulo", location, "Paulista",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 70);
        List<Restaurant> expectedRestaurants = Arrays.asList(restaurant1, restaurant2);

        when(restaurantGateway.findByLocation(location)).thenReturn(expectedRestaurants);

        List<Restaurant> actualRestaurants = getRestaurantByLocationUseCase.execute(location);

        assertEquals(expectedRestaurants, actualRestaurants);
        verify(restaurantGateway, times(1)).findByLocation(location);
    }
}