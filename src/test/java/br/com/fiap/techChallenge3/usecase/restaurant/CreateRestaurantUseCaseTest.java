package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreateRestaurantUseCaseTest {

    private RestaurantGateway restaurantGateway;
    private CreateRestaurantUseCase createRestaurantUseCase;

    @BeforeEach
    public void setUp() {
        restaurantGateway = mock(RestaurantGateway.class);
        createRestaurantUseCase = new CreateRestaurantUseCase(restaurantGateway);
    }

    @Test
    public void createRestaurantSucessTest() {

        IRestaurantRegistrationData registrationData = mock(IRestaurantRegistrationData.class);
        when(registrationData.name()).thenReturn("The Best Of Recife");
        when(registrationData.location()).thenReturn("Recife");
        when(registrationData.cuisineType()).thenReturn("Brasileira");
        when(registrationData.openingHours()).thenReturn("19:00");
        when(registrationData.capacity()).thenReturn(50);

        Restaurant createdRestaurant = new Restaurant("The Best Of Recife", "Recife", "Brasileira",
                LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm")), 50);
        when(restaurantGateway.create(any(Restaurant.class))).thenReturn(createdRestaurant);

        Restaurant result = createRestaurantUseCase.execute(registrationData);

        assertEquals(createdRestaurant, result);
        verify(restaurantGateway, times(1)).create(any(Restaurant.class));
    }
}