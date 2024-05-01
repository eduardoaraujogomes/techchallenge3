package br.com.fiap.techChallenge3.infraestructure.config.db.schema;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.reservation.model.Status;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "Reservation",
        uniqueConstraints = @UniqueConstraint(columnNames = {"\"hour\"", "date", "customer_id"})
)
@Getter
@Setter
public class ReservationSchema extends AbstractEntitySchema<Long> {
    @NotNull
    @Column(nullable = false, columnDefinition = "Time", name = "\"hour\"")
    private LocalTime hour;

    @NotNull
    @Column(nullable = false, columnDefinition = "Date", name = "date")
    private LocalDate date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantSchema restaurant;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerSchema customer;

    private Status status;

    public ReservationSchema(Reservation reservation) {
        this.hour = reservation.getHour();
        this.date = reservation.getDate();
        this.restaurant = new RestaurantSchema(reservation.getRestaurant());
        this.customer = new CustomerSchema(reservation.getCustomer());
    }

    public ReservationSchema() {

    }

    public Reservation toReservation() {
        Reservation reservation = new Reservation(
                this.customer.toCustomer(), this.hour, this.date, this.status, this.restaurant.toRestaurant()
        );
        reservation.setId(this.getId());
        return reservation;
    }
}
