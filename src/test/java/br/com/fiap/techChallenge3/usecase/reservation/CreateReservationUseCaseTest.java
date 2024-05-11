package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationRegistrationData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateReservationUseCaseTest {

    @Test
    public void shouldCreateReservationWithRestaurant() throws CustomerNotFoundException, RestaurantNotFoundException {
        CustomerGateway customerGateway = mock(CustomerGateway.class);
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        RestaurantGateway restaurantGateway = mock(RestaurantGateway.class);

        when(customerGateway.findById(any())).thenReturn(Optional.of(new Customer()));
        LocalTime localtime = LocalTime.parse("20:00", DateTimeFormatter.ofPattern("HH:00"));
        Restaurant restaurant = new Restaurant("Massa", "SP", "Italian", localtime, 10);
        when(restaurantGateway.findById(any())).thenReturn(Optional.of(restaurant));

        CreateReservationUseCase createReservationUseCase = new CreateReservationUseCase(customerGateway, reservationGateway, restaurantGateway);
        IReservationRegistrationData requestData = mock(IReservationRegistrationData.class);
        when(requestData.customerId()).thenReturn(1L);
        when(requestData.restaurantId()).thenReturn(2L);
        when(requestData.hour()).thenReturn("10:00");
        when(requestData.date()).thenReturn("10/05/2024");

        when(reservationGateway.create(any(Reservation.class))).thenReturn(new Reservation(new Customer(),localtime, LocalDate.now(), Status.CONFIRMED, restaurant));

        Reservation reservation = createReservationUseCase.execute(requestData);

        assertNotNull(reservation);
        assertEquals(Status.CONFIRMED, reservation.getStatus());
    }



    @Test
    public void shouldThrowCustomerNotFoundExceptionWhenRequestIsNotValid() throws CustomerNotFoundException, RestaurantNotFoundException {
        CustomerGateway customerGateway = mock(CustomerGateway.class);
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        RestaurantGateway restaurantGateway = mock(RestaurantGateway.class);

        when(customerGateway.findById(any())).thenReturn(Optional.empty());

        CreateReservationUseCase createReservationUseCase = new CreateReservationUseCase(customerGateway, reservationGateway, restaurantGateway);
        IReservationRegistrationData requestData = mock(IReservationRegistrationData.class);

        assertThrows(CustomerNotFoundException.class, () -> createReservationUseCase.execute(requestData));
    }
}
