package br.com.fiap.techChallenge3.usecase.reservation;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.entity.restaurant.exception.RestaurantNotFoundException;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.usecase.reservation.dto.IReservationRegistrationData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateReservationUseCase {

    private final CustomerGateway customerGateway;

    private final ReservationGateway reservationGateway;

    private final RestaurantGateway restaurantGateway;

    public CreateReservationUseCase(final CustomerGateway customerGateway,
                                    final ReservationGateway reservationGateway, final RestaurantGateway restaurantGateway) {
        this.customerGateway = customerGateway;
        this.reservationGateway = reservationGateway;
        this.restaurantGateway = restaurantGateway;
    }

    public Reservation execute(final IReservationRegistrationData request) throws CustomerNotFoundException, RestaurantNotFoundException {
        final Customer customer =
                this.customerGateway.findById(request.customerId()).orElseThrow(CustomerNotFoundException::new);

        final Restaurant restaurant =
                this.restaurantGateway.findById(request.restaurantId()).orElseThrow(RestaurantNotFoundException::new);


        Reservation reservation =
                new Reservation(
                        customer,
                        LocalTime.parse(request.hour(), DateTimeFormatter.ofPattern("HH:00")),
                        LocalDate.parse(request.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        Status.CONFIRMED,
                        restaurant);

        return this.reservationGateway.create(reservation);
    }
}
