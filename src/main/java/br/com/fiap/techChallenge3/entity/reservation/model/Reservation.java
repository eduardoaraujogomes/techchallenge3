package br.com.fiap.techChallenge3.entity.reservation.model;

import br.com.fiap.techChallenge3.entity.AbstractEntity;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Reservation extends AbstractEntity<Long> {

    private Restaurant restaurant;

    private Customer customer;

    private LocalTime hour;

    private LocalDate date;

    private Status status;

    public Reservation(Customer customer, LocalTime hour, LocalDate date, Status status, Restaurant restaurant) {
        this.customer = customer;
        this.hour = hour;
        this.date = date;
        this.status = status;
        this.restaurant = restaurant;
    }



}
