package br.com.fiap.techChallenge3.usecase.reservation.dto;

import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantCustomerData;
import java.time.LocalDate;
import java.time.LocalTime;

public interface IReservationCustomerData {
    Long id();

    LocalTime hour();

    LocalDate date();

    RestaurantCustomerData restaurant();

}
