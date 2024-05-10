package br.com.fiap.techChallenge3.usecase.reservation.dto;

import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantPublicData;
import java.time.LocalDate;
import java.time.LocalTime;

public interface IReservationPublicData {

    Long id();

    LocalTime hour();

    LocalDate date();

    IRestaurantPublicData restaurant();

    ICustomerPublicData customer();

}
