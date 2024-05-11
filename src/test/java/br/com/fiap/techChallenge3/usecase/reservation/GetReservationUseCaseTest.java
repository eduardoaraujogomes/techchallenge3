package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.reservation.exception.ReservationNotFoundException;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetReservationUseCaseTest {

    @Test
    public void shoudGetReservation() throws ReservationNotFoundException {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        GetReservationUseCase getReservationUseCase = new GetReservationUseCase(reservationGateway);
        Long reservationId = 1L;
        LocalTime localtime = LocalTime.parse("20:00", DateTimeFormatter.ofPattern("HH:00"));
        Restaurant restaurant = new Restaurant("Massa", "SP", "Italian", localtime, 10);
        Reservation reservation = new Reservation(new Customer(), localtime, LocalDate.now(), Status.CONFIRMED, restaurant);
        Reservation expectedReservation = reservation;

        when(reservationGateway.findById(reservationId)).thenReturn(Optional.of(expectedReservation));

        Reservation actualReservation = getReservationUseCase.execute(reservationId);

        assertNotNull(actualReservation);
        assertEquals(expectedReservation, actualReservation);
    }

    @Test
    public void shoudThrowCustomerNotFoundException() {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        GetReservationUseCase getReservationUseCase = new GetReservationUseCase(reservationGateway);
        Long reservationId = 1L;

        when(reservationGateway.findById(reservationId)).thenReturn(Optional.empty());

        assertThrows(ReservationNotFoundException.class, () -> getReservationUseCase.execute(reservationId));
    }
}
