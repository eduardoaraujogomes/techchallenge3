package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationPublicData;
import br.com.fiap.techChallenge3.usecase.reservation.SearchReservationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchReservationController {

    private final SearchReservationUseCase searchReservationUseCase;

    public SearchReservationController(SearchReservationUseCase searchReservationUseCase) {
        this.searchReservationUseCase = searchReservationUseCase;
    }

    @GetMapping("/reservations")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationPublicData> searchRentals() {
        List<Reservation> reservations = this.searchReservationUseCase.execute();

        return reservations.stream().map(ReservationPublicData::new).toList();
    }

}
