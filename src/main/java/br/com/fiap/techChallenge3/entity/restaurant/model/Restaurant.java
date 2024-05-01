package br.com.fiap.techChallenge3.entity.restaurant.model;

import br.com.fiap.techChallenge3.entity.AbstractEntity;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant extends AbstractEntity<Long>  {

    private String name;
    private String location;
    private String cuisineType;
    private LocalTime openingHours;
    private Integer capacity;
    private List <Review> reviews;
    private List<Reservation> reservations;

}
