package br.com.fiap.techChallenge3.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RestaurantHelper {

    public String bodyRequestRestaurant(){

        Faker faker = new Faker(new Locale("pt-BR"));

        String nomeRestaurante = "Restaurant " + faker.company().name();
        String localizacao = faker.address().city();
        String tipoCozinha = faker.food().dish();
        String horarioAbertura = "20:00";
        String capacidade = "150";

        String requestBody = "{\"name\":\"" + nomeRestaurante + "\",\"location\":\"" + localizacao + "\",\"cuisineType\":\"" + tipoCozinha + "\",\"openingHours\":\"" + horarioAbertura + "\",\"capacity\":\"" + capacidade + "\"}";
        return requestBody;
    }

}
