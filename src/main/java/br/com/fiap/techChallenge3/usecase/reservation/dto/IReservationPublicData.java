package br.com.fiap.techChallenge3.usecase.reservation.dto;

import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerPublicData;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IReservationPublicData {

    Long id();

    LocalTime hour();

    LocalDate date();

//    IRestaurantPublicData restaurant();

    ICustomerPublicData customer();

}
