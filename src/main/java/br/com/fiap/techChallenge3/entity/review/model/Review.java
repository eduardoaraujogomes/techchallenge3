package br.com.fiap.techChallenge3.entity.review.model;


import br.com.fiap.techChallenge3.entity.AbstractEntity;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review extends AbstractEntity {
//    @Id
//    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private Long userId;
    private Double rating;
    private String comment;
}
