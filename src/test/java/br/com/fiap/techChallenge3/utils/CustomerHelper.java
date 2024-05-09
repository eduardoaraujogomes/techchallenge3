package br.com.fiap.techChallenge3.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class CustomerHelper {

    public String bodyRequestCustomer(){

        Faker faker = new Faker(new Locale("pt-BR"));

        String username = "userx";
        String password = faker.internet().password(2, 5);
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String cpf = faker.number().digits(11);
        String phoneNumber = faker.phoneNumber().cellPhone();
        String status = "CONFIRMED";

        String requestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\",\"name\":\"" + name + "\",\"email\":\"" + email + "\",\"cpf\":\"" + cpf + "\",\"phoneNumber\":\"" + phoneNumber + "\",\"status\":\"" + status +"\"}";
        return requestBody;
    }
}
