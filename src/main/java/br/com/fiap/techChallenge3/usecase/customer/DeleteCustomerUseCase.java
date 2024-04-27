package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;

public class DeleteCustomerUseCase {

    private final CustomerGateway customerGateway;

    public DeleteCustomerUseCase(final CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public void execute(final Long id) {
        Customer customer = customerGateway.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        customerGateway.delete(customer.getId());
    }
}
