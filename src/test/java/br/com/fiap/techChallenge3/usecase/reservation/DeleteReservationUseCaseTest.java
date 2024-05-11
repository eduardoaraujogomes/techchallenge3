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
import static org.mockito.Mockito.*;

public class DeleteReservationUseCaseTest {

    @Test
    public void shouldDeleteReservation() throws ReservationNotFoundException {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        DeleteReservationUseCase deleteReservationUseCase = new DeleteReservationUseCase(reservationGateway);
        Long reservationId = 1L;
        LocalTime localtime = LocalTime.parse("20:00", DateTimeFormatter.ofPattern("HH:00"));
        Restaurant restaurant = new Restaurant("Massa", "SP", "Italian", localtime, 10);
        Reservation reservation = new Reservation(new Customer(), localtime, LocalDate.now(), Status.CONFIRMED, restaurant);
        reservation.setId(reservationId);
        when(reservationGateway.findById(reservationId)).thenReturn(Optional.of(reservation));

        assertDoesNotThrow(() -> deleteReservationUseCase.execute(reservationId));

        verify(reservationGateway, times(1)).delete(reservationId);
    }

    @Test
    public void shouldThrowReservationNotFound() {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        DeleteReservationUseCase deleteReservationUseCase = new DeleteReservationUseCase(reservationGateway);
        Long reservationId = 1L;

        when(reservationGateway.findById(reservationId)).thenReturn(Optional.empty());

        assertThrows(ReservationNotFoundException.class, () -> deleteReservationUseCase.execute(reservationId));
        verify(reservationGateway, never()).delete(anyLong());
    }
}
