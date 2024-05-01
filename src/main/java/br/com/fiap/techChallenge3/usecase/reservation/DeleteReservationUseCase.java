package br.com.fiap.techChallenge3.usecase.reservation;
import br.com.fiap.techChallenge3.entity.reservation.exception.ReservationNotFoundException;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;

public class DeleteReservationUseCase {

    private final ReservationGateway reservationGateway;

    public DeleteReservationUseCase(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    public void execute(Long id) {
        Reservation reservation = reservationGateway.findById(id)
                .orElseThrow(ReservationNotFoundException::new);

        reservationGateway.delete(reservation.getId());
    }

}
