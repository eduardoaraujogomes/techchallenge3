package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import java.util.List;

public class SearchCustomerUseCase {

    private final CustomerGateway customerGateway;

    public SearchCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public List<Customer> execute() {
        return this.customerGateway.findAll();
    }
}
