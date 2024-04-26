package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerUpdateData;
import java.util.function.Consumer;

public class UpdateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public UpdateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(final Long id, final ICustomerUpdateData request) throws CustomerNotFoundException {
        Customer customer = this.customerGateway.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        setIfNotBlank(request.username(), customer::setUsername);
        setIfNotBlank(request.password(), customer::setPassword);
        setIfNotBlank(request.name(), customer::setName);
        setIfNotBlank(request.email(), customer::setEmail);
        setIfNotBlank(request.cpf(), customer::setCpf);
        setIfNotBlank(request.phoneNumber(), customer::setPhoneNumber);

        return this.customerGateway.update(customer);

    }

    private void setIfNotBlank(final String value, final Consumer<String> setter) {
        if (value != null && !value.isBlank()) {
            setter.accept(value);
        }
    }

}
