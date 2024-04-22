package br.com.fiap.techChallenge3.entity.reservation.gateway;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationGateway {
    Reservation create(Reservation reservation);
    Reservation update(Reservation reservation);
    void delete(Long id);
    Optional<Reservation> findById (Long id);
    List<Reservation> findAll();

}
