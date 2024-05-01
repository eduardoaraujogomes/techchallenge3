package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;

public class GetCustomerUseCase {

    private final CustomerGateway customerGateway;

    public GetCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(Long id) throws CustomerNotFoundException {
        return this.customerGateway
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);
    }
}
