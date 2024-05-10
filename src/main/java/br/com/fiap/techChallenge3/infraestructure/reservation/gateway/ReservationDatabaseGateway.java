package br.com.fiap.techChallenge3.infraestructure.reservation.gateway;

import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReservationRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.ReservationSchema;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class ReservationDatabaseGateway implements ReservationGateway {

    private final ReservationRepository reservationRepository;

    public ReservationDatabaseGateway(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    @Transactional
    public Reservation create(Reservation reservation) {
        return this.reservationRepository.save(new ReservationSchema(reservation)).toReservation();
    }

    @Override
    public Reservation update(Reservation reservation) {
        return this.reservationRepository.save(new ReservationSchema(reservation)).toReservation();
    }

    @Override
    public void delete(Long id) {
        this.reservationRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository
                .findById(id)
                .map(ReservationSchema::toReservation);
    }

//    @Override
//    public List<Reservation> findAllByRestaurant(Long restaurantId) {
//        return this.reservationRepository .findAllByRestaurantId(new Reservation(res))
//                .stream()
//                .map(ReservationSchema::toReservation)
//                .toList();
//        return null;
//    }

    @Override
    public List<Reservation> findAllByCustomer(Long customerId) {
        return this.reservationRepository.findAllByCustomerId(customerId)
                .stream()
                .map(ReservationSchema::toReservation)
                .toList();
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
