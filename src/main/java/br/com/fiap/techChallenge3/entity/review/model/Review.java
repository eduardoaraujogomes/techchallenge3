package br.com.fiap.techChallenge3.entity.review.model;


import br.com.fiap.techChallenge3.entity.AbstractEntity;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review extends AbstractEntity<Long> {

    private Restaurant restaurant;

    private Customer customer;

    private Double rating;

    private String comment;

    public Review(Restaurant restaurant, Customer customer, Double rating, String comment) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
    }
}
