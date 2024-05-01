package br.com.fiap.techChallenge3.infraestructure.customer.controller;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.infraestructure.customer.dto.CostumerUpdateData;
import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerPublicData;
import br.com.fiap.techChallenge3.usecase.customer.UpdateCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCustomerController {

    private final UpdateCustomerUseCase updateCustomerUseCase;

    public UpdateCustomerController(UpdateCustomerUseCase updateCustomerUseCase) {
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData createCustomer(@PathVariable Long id, @Valid @RequestBody CostumerUpdateData request)
            throws CustomerNotFoundException {
        return new CustomerPublicData(updateCustomerUseCase.execute(id, request));
    }

}
