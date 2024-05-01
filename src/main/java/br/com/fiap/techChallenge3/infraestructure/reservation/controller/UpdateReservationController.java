package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationPublicData;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationUpdateData;
import br.com.fiap.techChallenge3.usecase.reservation.UpdateReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateReservationController {

    private final UpdateReservationUseCase updateReservationUseCase;

    public UpdateReservationController(UpdateReservationUseCase updateReservationUseCase) {
        this.updateReservationUseCase = updateReservationUseCase;
    }

    @PutMapping("/reservations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationPublicData updateReservation(@PathVariable Long id, @Valid @RequestBody ReservationUpdateData request) {
        return new ReservationPublicData(updateReservationUseCase.execute(id, request));
    }

}
