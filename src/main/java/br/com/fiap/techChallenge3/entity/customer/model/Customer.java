package br.com.fiap.techChallenge3.entity.customer.model;

import br.com.fiap.techChallenge3.entity.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends User {

    private String cpf;
    private String phoneNumber;

    public Customer(String username, String email, String password, String name, String cpf, String phoneNumber) {
        super(username, email, password, name);
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
    }

}
