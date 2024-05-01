package br.com.fiap.techChallenge3.entity.customer.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Customer not found!");
    }
}
