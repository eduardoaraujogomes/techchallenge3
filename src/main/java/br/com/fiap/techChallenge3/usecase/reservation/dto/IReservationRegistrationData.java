package br.com.fiap.techChallenge3.usecase.reservation.dto;

public interface IReservationRegistrationData {

    String hour();

    String date();

    Long restaurantId();

    Long customerId();


}
