package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.reservation.exception.ReservationNotFoundException;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationUpdateData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UpdateReservationUseCaseTest {

    @Test
    public void shouldUpdateReservationHourAndDate() throws ReservationNotFoundException {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        UpdateReservationUseCase updateReservationUseCase = new UpdateReservationUseCase(reservationGateway);
        Long reservationId = 1L;
        LocalTime localtime = LocalTime.parse("20:00", DateTimeFormatter.ofPattern("HH:00"));
        Restaurant restaurant = new Restaurant("Massa", "SP", "Italian", localtime, 10);
        Reservation existingReservation = new Reservation(new Customer(), localtime, LocalDate.now(), Status.CONFIRMED, restaurant);

        IReservationUpdateData requestData = mock(IReservationUpdateData.class);
        String updatedDate = "20/05/2024";
        String updatedHour = "18:00";

        when(reservationGateway.findById(reservationId)).thenReturn(Optional.of(existingReservation));
        when(requestData.date()).thenReturn(updatedDate);
        when(requestData.hour()).thenReturn(updatedHour);

        when(reservationGateway.update(existingReservation)).thenReturn(existingReservation);

        Reservation updatedReservation = updateReservationUseCase.execute(reservationId, requestData);

        assertNotNull(updatedReservation);
        assertEquals(LocalDate.parse(updatedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), updatedReservation.getDate());
        assertEquals(LocalTime.parse(updatedHour, DateTimeFormatter.ofPattern("HH:mm")), updatedReservation.getHour());
    }

    @Test
    public void shouldThrowsExceptionReservationNotFound() {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        UpdateReservationUseCase updateReservationUseCase = new UpdateReservationUseCase(reservationGateway);
        Long reservationId = 1L;
        IReservationUpdateData requestData = mock(IReservationUpdateData.class);

        when(reservationGateway.findById(reservationId)).thenReturn(Optional.empty());

        assertThrows(ReservationNotFoundException.class, () -> updateReservationUseCase.execute(reservationId, requestData));

    }
}
