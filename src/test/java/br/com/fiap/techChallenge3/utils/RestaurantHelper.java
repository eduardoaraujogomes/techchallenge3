package br.com.fiap.techChallenge3.utils;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import com.github.javafaker.Faker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RestaurantHelper {

    public String bodyRequestRestaurant(){

        Faker faker = new Faker(new Locale("pt-BR"));

        String nomeRestaurante = "Restaurant " + faker.company().name();
        String localizacao = "Industrial";
        String tipoCozinha = "Brasileira";
        String horarioAbertura = "20:00";
        String capacidade = "150";

        String requestBody = "{\"name\":\"" + nomeRestaurante + "\",\"location\":\"" + localizacao + "\",\"cuisineType\":\"" + tipoCozinha + "\",\"openingHours\":\"" + horarioAbertura + "\",\"capacity\":\""+ capacidade +"\"}";
        return requestBody;
    }

    public Restaurant generatorRestaurant(){

        Restaurant restaurant =  new Restaurant();
        restaurant.setId( 1L );
        restaurant.setName( "Pedro");
        restaurant.setLocation( "Industrial");
        restaurant.setCuisine( "Brasileira");
        restaurant.setOpeningHours( LocalTime.of(19, 0));
        restaurant.setCapacity(50);
        return restaurant;
    }
}
