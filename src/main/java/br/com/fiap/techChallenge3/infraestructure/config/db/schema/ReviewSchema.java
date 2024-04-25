package br.com.fiap.techChallenge3.infraestructure.config.db.schema;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
public class ReviewSchema extends AbstractEntitySchema<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @NotNull
    private Long userId;
    @NotNull
    private Double rating;
    @NotNull
    private String comment;

    public ReviewSchema(Review review){
        this.restaurant = review.getRestaurant();
        this.userId = review.getUserId();
        this.rating = review.getRating();
        this.comment = review.getComment();

    }

    public Review toReview(){
        Review review = new Review(
                this.getRestaurant(),
                this.getUserId(),
                this.getRating(),
                this.getComment()
        );
        review.setId(this.getId());
        return review;
    }
}
