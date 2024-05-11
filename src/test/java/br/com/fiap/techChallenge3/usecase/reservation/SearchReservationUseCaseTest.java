package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchReservationUseCaseTest {

    @Test
     public void shouldReturnListOfReservations() {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        SearchReservationUseCase searchReservationUseCase = new SearchReservationUseCase(reservationGateway);
        List<Reservation> expectedReservations = createSampleReservationList();

        when(reservationGateway.findAll()).thenReturn(expectedReservations);

        List<Reservation> actualReservations = searchReservationUseCase.execute();

        assertNotNull(actualReservations);
        assertEquals(expectedReservations.size(), actualReservations.size());
        assertTrue(expectedReservations.containsAll(actualReservations));
    }

    @Test
    public void shouldReturnEmptyListOfReservations() {
        ReservationGateway reservationGateway = mock(ReservationGateway.class);
        SearchReservationUseCase searchReservationUseCase = new SearchReservationUseCase(reservationGateway);

        when(reservationGateway.findAll()).thenReturn(Collections.emptyList());

        List<Reservation> actualReservations = searchReservationUseCase.execute();

        assertNotNull(actualReservations);
        assertTrue(actualReservations.isEmpty());
    }

    private List<Reservation> createSampleReservationList() {
        LocalTime localtime = LocalTime.parse("20:00", DateTimeFormatter.ofPattern("HH:00"));
        Restaurant restaurant = new Restaurant("Massa", "SP", "Italian", localtime, 10);
        Reservation reservation = new Reservation(new Customer(), localtime, LocalDate.now(), Status.CONFIRMED, restaurant);
        Reservation expectedReservation = reservation;
        ArrayList<Reservation> reservations = new ArrayList<>();
        reservations.add(expectedReservation);
        return reservations;
    }
}
