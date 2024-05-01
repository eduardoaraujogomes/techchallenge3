package br.com.fiap.techChallenge3.infraestructure.customer.controller;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.usecase.customer.DeleteCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCustomerController {

    private final DeleteCustomerUseCase deleteCustomerUseCase;

    public DeleteCustomerController(DeleteCustomerUseCase deleteCustomerUseCase) {
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }


    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        deleteCustomerUseCase.execute(id);
    }
}
