package br.com.fiap.techChallenge3.entity.reservation.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException() {
        super("Reserva não encontrada!");
    }
}
