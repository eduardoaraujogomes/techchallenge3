package br.com.fiap.techChallenge3.entity.restaurant.model;

import br.com.fiap.techChallenge3.entity.AbstractEntity;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restaurant extends AbstractEntity<Long> {

    private String name;

    private String location;

    private String cuisine;

    private LocalTime openingHours;

    private Integer capacity;

    private List<Review> reviews = new ArrayList<>();

    private List<Reservation> reservations = new ArrayList<>();

    public Restaurant(String name, String location, String cuisine, LocalTime openingHours, Integer capacity) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
        this.openingHours = openingHours;
        this.capacity = capacity;
    }

}
