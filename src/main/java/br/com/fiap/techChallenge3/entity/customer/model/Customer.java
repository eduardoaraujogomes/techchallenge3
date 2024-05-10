package br.com.fiap.techChallenge3.entity.customer.model;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.entity.user.model.User;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends User {

    private String cpf;

    private String phoneNumber;

    private List<Reservation> reservations = new ArrayList<>();

    private List<Review> reviews = new ArrayList<>();

    public Customer(String username, String email, String password, String name, String cpf, String phoneNumber) {
        super(username, email, password, name);
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String username, String email, String password, String name, String cpf, String phoneNumber,
                    List<Reservation> reservations, List<Review> reviews) {
        super(username, email, password, name);
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.reservations = reservations;
        this.reviews = reviews;
    }

    public Customer(){
        super();
    }
}
