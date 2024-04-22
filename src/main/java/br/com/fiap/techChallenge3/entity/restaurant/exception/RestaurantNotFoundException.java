package br.com.fiap.techChallenge3.entity.restaurant.exception;

public class RestaurantNotFoundException extends Exception{
    public RestaurantNotFoundException(){
        super("Restaurante não encontrado!");
    }
}
