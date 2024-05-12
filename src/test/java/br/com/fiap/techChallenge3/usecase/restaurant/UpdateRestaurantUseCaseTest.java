package br.com.fiap.techChallenge3.usecase.restaurant;

import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantUpdateData;
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

class UpdateRestaurantUseCaseTest {

    @Mock
    private RestaurantGateway restaurantGateway;

    private UpdateRestaurantUseCase updateRestaurantUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        updateRestaurantUseCase = new UpdateRestaurantUseCase(restaurantGateway);
    }

    @Test
    void shouldUpateRestaurantSuccessTest() throws RestaurantNotFoundException {
        long restaurantId = 1L;
        RestaurantUpdateData updateData = new RestaurantUpdateData(
                "The Best Of Recife", "Recife", "Brasileira",
                "19:00", "50"
        );

        Restaurant existingRestaurant = new Restaurant("Old The Best Of Recife", "Old Recife", "Old Brasileira", LocalTime.parse("09:00"), 50);
        existingRestaurant.setId(restaurantId);

        RestaurantGateway restaurantGateway = mock(RestaurantGateway.class);

        when(restaurantGateway.findById(restaurantId)).thenReturn(Optional.of(existingRestaurant));
        when(restaurantGateway.update(existingRestaurant)).thenReturn(existingRestaurant);

        UpdateRestaurantUseCase updateRestaurantUseCase = new UpdateRestaurantUseCase(restaurantGateway);
        Restaurant updatedRestaurant = updateRestaurantUseCase.execute(restaurantId, updateData);

        assertEquals(updateData.name(), updatedRestaurant.getName());
        assertEquals(updateData.location(), updatedRestaurant.getLocation());
        assertEquals(updateData.cuisineType(), updatedRestaurant.getCuisine());
        assertEquals(LocalTime.parse(updateData.openingHours(), DateTimeFormatter.ofPattern("HH:mm")), updatedRestaurant.getOpeningHours());
        assertEquals(Integer.parseInt(updateData.capacity()), updatedRestaurant.getCapacity());

        verify(restaurantGateway, times(1)).findById(restaurantId);
        verify(restaurantGateway, times(1)).update(existingRestaurant);
    }

    @Test
    void shouldUpdateRestaurantNotFoundTest() {

        long nonExistingRestaurantId = 2L;
        RestaurantUpdateData updateData = new RestaurantUpdateData("New Name", "New Location", "New Cuisine",
                "10:00", "100");

        when(restaurantGateway.findById(nonExistingRestaurantId)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> updateRestaurantUseCase.execute(nonExistingRestaurantId, updateData));
        verify(restaurantGateway, times(1)).findById(nonExistingRestaurantId);
        verify(restaurantGateway, never()).update(any());
    }

}