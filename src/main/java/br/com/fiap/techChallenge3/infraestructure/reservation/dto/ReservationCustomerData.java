package br.com.fiap.techChallenge3.infraestructure.reservation.dto;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantCustomerData;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationCustomerData;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationCustomerData(Long id,

                                      @JsonFormat(pattern = "HH:00")
                                      LocalTime hour,

                                      @JsonFormat(pattern = "dd/MM/yyyy")
                                      LocalDate date,


                                      Status status,
                                      RestaurantCustomerData restaurant

) implements IReservationCustomerData {
    public ReservationCustomerData(Reservation reservation) {
        this(
                reservation.getId(),
                reservation.getHour(),
                reservation.getDate(),
                reservation.getStatus(),
                new RestaurantCustomerData(reservation.getRestaurant())
        );
    }

}

