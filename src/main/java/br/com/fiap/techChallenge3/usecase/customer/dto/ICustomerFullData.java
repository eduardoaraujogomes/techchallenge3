package br.com.fiap.techChallenge3.usecase.customer.dto;

import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationCustomerData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewCustomerData;
import java.util.List;

public interface ICustomerFullData {

    String username();

    String password();

    String name();

    String email();

    String cpf();

    String phoneNumber();

    List<ReservationCustomerData> reservations();

    List<ReviewCustomerData> reviews();
}
