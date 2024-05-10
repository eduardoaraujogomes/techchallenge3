package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerRegistrationData;

public class CreateCustomerUseCase {


    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(ICustomerRegistrationData request) {
        if (request == null) {
            throw new IllegalArgumentException("Request is not valid");
        }

        Customer customer = new Customer(request.username(), request.email(), request.password(), request.name(),
                 request.cpf(), request.phoneNumber());

        return this.customerGateway.create(customer);
    }

}
