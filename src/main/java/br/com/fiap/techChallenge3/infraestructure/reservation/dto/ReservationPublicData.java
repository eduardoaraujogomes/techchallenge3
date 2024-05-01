package br.com.fiap.techChallenge3.infraestructure.reservation.dto;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerPublicData;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationPublicData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationPublicData(
        Long id,

        @JsonFormat(pattern = "HH:00")
        LocalTime hour,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date,

        RestaurantPublicData restaurant,

        CustomerPublicData customer,

        Status status

) implements IReservationPublicData {
    public ReservationPublicData(Reservation reservation) {
        this(
                reservation.getId(),
                reservation.getHour(),
                reservation.getDate(),
                new RestaurantPublicData(reservation.getRestaurant()),
                new CustomerPublicData(reservation.getCustomer()),
                reservation.getStatus()
        );
    }
}
