package br.com.fiap.techChallenge3.infraestructure.config.db.schema;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Restaurant", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})})
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

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ReviewSchema> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ReservationSchema> reservations;

    public RestaurantSchema(Restaurant restaurant) {
        this.setId(restaurant.getId());
        this.name = restaurant.getName();
        this.location = restaurant.getLocation();
        this.cuisine = restaurant.getCuisine();
        this.openingHours = restaurant.getOpeningHours();
        this.capacity = restaurant.getCapacity();
    }

    public Restaurant toRestaurant() {
        Restaurant restaurant = new Restaurant(this.getName(),
                this.getLocation(),
                this.getCuisine(),
                this.getOpeningHours(),
                this.getCapacity());
        restaurant.setId(this.getId());
        return restaurant;
    }

}
