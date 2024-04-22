package br.com.fiap.techChallenge3.entity.reservation.model;

import br.com.fiap.techChallenge3.entity.AbstractEntity;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Reservation extends AbstractEntity<Long> {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;
    private LocalTime time;
    private Integer partySize;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
