package br.com.fiap.techChallenge3.infraestructure.customer.controller;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerFullData;
import br.com.fiap.techChallenge3.usecase.customer.GetCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCustomerController {

    private final GetCustomerUseCase getCustomerUseCase;

    public GetCustomerController(GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerFullData getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        Customer customer = getCustomerUseCase.execute(id);

        return new CustomerFullData(customer);
    }

}
