package br.com.fiap.techChallenge3.infraestructure.config.db.schema;
import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
public class RestaurantSchema extends AbstractEntitySchema<Long> {

    @NotNull
    private String name;
    @NotNull
    private String location;
    @NotNull
    private String cuisine;
    @NotNull
    private LocalTime openingHours;
    @NotNull
    private Integer capacity;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReviewSchema> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReservationSchema> reservations;

    public RestaurantSchema(Restaurant restaurant){
        this.name = restaurant.getName();
        this.location = restaurant.getLocation();
        this.cuisine = restaurant.getCuisineType();
        this.openingHours = restaurant.getOpeningHours();
        this.capacity = restaurant.getCapacity();
        this.reviews = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public Restaurant toRestaurant(){
        Restaurant restaurant = new Restaurant(this.getName(),
                this.getLocation(),
                this.getCuisine(),
                this.getOpeningHours(),
                this.getCapacity(),
                this.reviews.stream().map(ReviewSchema::toReview).collect(Collectors.toList()),
                this.reservations.stream().map(ReservationSchema::toReservation).collect(Collectors.toList()));
        restaurant.setId(this.getId());
        return restaurant;
    }

}
