package br.com.fiap.techChallenge3.infraestructure.customer.dto;

import br.com.fiap.techChallenge3.infraestructure.user.validation.formats.CPF;
import br.com.fiap.techChallenge3.infraestructure.user.validation.formats.Name;
import br.com.fiap.techChallenge3.infraestructure.user.validation.formats.PhoneNumber;
import br.com.fiap.techChallenge3.infraestructure.user.validation.unique.UniqueCPF;
import br.com.fiap.techChallenge3.infraestructure.user.validation.unique.UniqueEmail;
import br.com.fiap.techChallenge3.infraestructure.user.validation.unique.UniqueUsername;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerUpdateData;
import jakarta.validation.constraints.Email;

public record CostumerUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCPF(message = "{Unique.customer.CPF}")
        @CPF(message = "{Size.customer.CPF}")
        String cpf,

        @PhoneNumber(message = "{Size.customer.phone}")
        String phoneNumber) implements ICustomerUpdateData {
}
