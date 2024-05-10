package br.com.fiap.techChallenge3.infraestructure.reservation.dto;

import br.com.fiap.techChallenge3.infraestructure.validation.classLevel.ValidReservationRegistrationData;
import br.com.fiap.techChallenge3.infraestructure.validation.formats.ReservationDate;
import br.com.fiap.techChallenge3.infraestructure.validation.formats.ReservationHour;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationRegistrationData;
import jakarta.validation.constraints.NotNull;
@ValidReservationRegistrationData(message = "{ValidRental.reservation}")
public record ReservationRegistrationData(
        @ReservationHour(message = "{Hour.reservation}")
        @NotNull
        String hour,

        @ReservationDate(message = "{Date.reservation}")
        @NotNull
        String date,

        @NotNull
        Long restaurantId,

        @NotNull
        Long customerId
) implements IReservationRegistrationData { }
