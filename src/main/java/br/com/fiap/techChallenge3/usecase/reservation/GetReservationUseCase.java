package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.reservation.exception.ReservationNotFoundException;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;

public class GetReservationUseCase {

    private final ReservationGateway reservationGateway;

    public GetReservationUseCase(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    public Reservation execute(Long id) {
        return this.reservationGateway
                .findById(id)
                .orElseThrow(ReservationNotFoundException::new);
    }
}
