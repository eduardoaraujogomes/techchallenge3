package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.usecase.reservation.DeleteReservationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteReservationController {

    private final DeleteReservationUseCase deleteReservationUseCase;

    public DeleteReservationController(DeleteReservationUseCase deleteReservationUseCase) {
        this.deleteReservationUseCase = deleteReservationUseCase;
    }

    @DeleteMapping("/reservations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReservation(@PathVariable Long id) {
        deleteReservationUseCase.execute(id);
    }

}
