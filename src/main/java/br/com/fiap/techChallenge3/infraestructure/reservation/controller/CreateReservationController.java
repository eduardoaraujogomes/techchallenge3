package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationPublicData;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationRegistrationData;
import br.com.fiap.techChallenge3.usecase.reservation.CreateReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateReservationController {

    private CreateReservationUseCase reservationUseCase;

    public CreateReservationController(CreateReservationUseCase reservationUseCase) {
        this.reservationUseCase = reservationUseCase;
    }

    @PostMapping("/reservations")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationPublicData createReservation(@Valid @RequestBody ReservationRegistrationData request) {
        return new ReservationPublicData(reservationUseCase.execute(request));
    }
}
