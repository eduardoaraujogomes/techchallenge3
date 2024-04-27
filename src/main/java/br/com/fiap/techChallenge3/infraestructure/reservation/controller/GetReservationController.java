package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationPublicData;
import br.com.fiap.techChallenge3.usecase.reservation.GetReservationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetReservationController {

    private final GetReservationUseCase getReservationUseCase;

    public GetReservationController(GetReservationUseCase getReservationUseCase) {
        this.getReservationUseCase = getReservationUseCase;
    }

    @GetMapping("/reservations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationPublicData getReservation(@PathVariable Long id) {
        Reservation reservation = getReservationUseCase.execute(id);

        return new ReservationPublicData(reservation);
    }

}
