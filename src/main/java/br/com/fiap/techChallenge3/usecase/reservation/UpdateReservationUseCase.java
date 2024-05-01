package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.reservation.exception.ReservationNotFoundException;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationUpdateData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UpdateReservationUseCase {

    private final ReservationGateway reservationGateway;

    public UpdateReservationUseCase(final ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    public Reservation execute(final Long id, final IReservationUpdateData request) {
        Reservation reservation = this.reservationGateway.findById(id)
                .orElseThrow(ReservationNotFoundException::new);

        if (request.date() != null && !request.date().isBlank()) {
            reservation.setDate(LocalDate.parse(request.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }

        if (request.hour() != null && !request.hour().isBlank()) {
            reservation.setHour(LocalTime.parse(request.hour(), DateTimeFormatter.ofPattern("HH:00")));
        }

        return this.reservationGateway.update(reservation);

    }

}
