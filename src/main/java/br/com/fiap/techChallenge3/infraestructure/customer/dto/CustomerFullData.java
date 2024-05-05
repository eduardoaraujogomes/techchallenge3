package br.com.fiap.techChallenge3.infraestructure.customer.dto;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationCustomerData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewCustomerData;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerFullData;
import java.util.List;

public record CustomerFullData(
        Long id,

        String username,

        String name,

        String email,

        String password,

        String phoneNumber,

        String cpf,
        List<ReservationCustomerData> reservations,
        List<ReviewCustomerData> reviews) implements ICustomerFullData {

    public CustomerFullData(Customer customer) {
        this(
                customer.getId(),
                customer.getUsername(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getPhoneNumber(),
                customer.getCpf(),
                customer.getReservations().stream().map(ReservationCustomerData::new).toList(),
                customer.getReviews().stream().map(ReviewCustomerData::new).toList()
        );
    }

}
