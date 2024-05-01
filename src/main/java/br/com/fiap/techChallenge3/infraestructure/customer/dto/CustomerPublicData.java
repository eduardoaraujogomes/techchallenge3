package br.com.fiap.techChallenge3.infraestructure.customer.dto;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerPublicData;

public record CustomerPublicData(
        String id,

        String username,

        String name,

        String email,

        String phoneNumber
) implements ICustomerPublicData {
    public CustomerPublicData(Customer customer) {
        this(
                customer.getId().toString(),
                customer.getUsername(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
}