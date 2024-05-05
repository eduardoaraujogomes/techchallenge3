package br.com.fiap.techChallenge3.infraestructure.config.db.schema;

import br.com.fiap.techChallenge3.entity.review.model.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
public class ReviewSchema extends AbstractEntitySchema<Long> {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private RestaurantSchema restaurant;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private CustomerSchema customer;

    @NotNull
    private Double rating;

    @NotNull
    private String comment;

    public ReviewSchema(Review review) {
        this.restaurant = new RestaurantSchema(review.getRestaurant());
        this.customer = new CustomerSchema(review.getCustomer());
        this.rating = review.getRating();
        this.comment = review.getComment();

    }

    public Review toReview() {
        Review review = new Review(
                this.restaurant.toRestaurant(),
                this.getCustomer().toCustomer(),
                this.getRating(),
                this.getComment()
        );
        review.setId(this.getId());
        return review;
    }
}
