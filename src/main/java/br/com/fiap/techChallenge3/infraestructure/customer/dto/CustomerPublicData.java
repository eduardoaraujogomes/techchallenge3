package br.com.fiap.techChallenge3.infraestructure.customer.dto;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationPublicData;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerPublicData;
import java.util.List;

public record CustomerPublicData(
        Long id,

        String username,

        String name,

        String email,

        String phoneNumber
) implements ICustomerPublicData {
    public CustomerPublicData(Customer customer) {
        this(
                customer.getId(),
                customer.getUsername(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
}