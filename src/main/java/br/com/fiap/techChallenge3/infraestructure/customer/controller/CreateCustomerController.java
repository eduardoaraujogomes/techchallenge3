package br.com.fiap.techChallenge3.infraestructure.customer.controller;

import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerPublicData;
import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerRegistrationData;
import br.com.fiap.techChallenge3.usecase.customer.CreateCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    public CreateCustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerPublicData createCustomer(@Valid @RequestBody CustomerRegistrationData request) {
        return new CustomerPublicData(createCustomerUseCase.execute(request));
    }
}
