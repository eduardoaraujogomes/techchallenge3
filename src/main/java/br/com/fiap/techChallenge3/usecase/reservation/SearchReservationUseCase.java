package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;

import java.util.List;

public class SearchReservationUseCase {

    private final ReservationGateway reservationGateway;

    public SearchReservationUseCase(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    public List<Reservation> execute() {
        return this.reservationGateway.findAll();
    }
}
