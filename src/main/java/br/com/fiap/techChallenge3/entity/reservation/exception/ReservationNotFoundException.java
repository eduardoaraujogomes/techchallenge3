package br.com.fiap.techChallenge3.entity.reservation.exception;

public class ReservationNotFoundException extends Exception{
    public ReservationNotFoundException(){
        super("Reserva não encontrada!");
    }
}
