package br.com.fiap.techChallenge3.infraestructure.customer.dto;

import br.com.fiap.techChallenge3.infraestructure.validation.formats.CPF;
import br.com.fiap.techChallenge3.infraestructure.validation.formats.Name;
import br.com.fiap.techChallenge3.infraestructure.validation.formats.PhoneNumber;
import br.com.fiap.techChallenge3.infraestructure.validation.unique.UniqueCPF;
import br.com.fiap.techChallenge3.infraestructure.validation.unique.UniqueEmail;
import br.com.fiap.techChallenge3.infraestructure.validation.unique.UniqueUsername;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerRegistrationData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRegistrationData(
        @UniqueUsername(message = "{Unique.user.username}")
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @NotBlank
        @Email
        String email,

        @UniqueCPF(message = "{Unique.customer.CPF}")
        @NotBlank
        @CPF(message = "{Size.customers.CPF}")
        String cpf,

        @NotBlank
        @PhoneNumber(message = "{Size.customer.phone}")
        String phoneNumber) implements ICustomerRegistrationData {
}
