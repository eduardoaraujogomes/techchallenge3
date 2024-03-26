package service;

import entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        if (reservationRepository.existsById(id)) {
            updatedReservation.setId(id);
            return reservationRepository.save(updatedReservation);
        }
        return null;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
