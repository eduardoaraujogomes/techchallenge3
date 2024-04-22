package br.com.fiap.techChallenge3.infraestructure.reservation.gateway;

import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReservationRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.ReservationSchema;

import java.util.List;
import java.util.Optional;

public class ReservationDatabaseGateway implements ReservationGateway {

    private final ReservationRepository reservationRepository;

    public ReservationDatabaseGateway(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(new ReservationSchema(reservation)).toReservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository
                .findById(id)
                .map(ReservationSchema::toReservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository
                .findAll()
                .stream()
                .map(ReservationSchema::toReservation)
                .toList();
    }
}
