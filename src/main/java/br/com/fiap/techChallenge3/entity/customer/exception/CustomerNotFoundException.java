package br.com.fiap.techChallenge3.entity.customer.exception;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException() {
        super("Customer not found!");
    }
}
