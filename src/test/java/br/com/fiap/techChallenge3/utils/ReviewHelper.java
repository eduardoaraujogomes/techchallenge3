package br.com.fiap.techChallenge3.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class ReviewHelper {

    public String bodyRequestReview(){


        Integer restaurantId = 1;
        Integer userId = 1;
        String rating = "3.0";
        String comment = "Muito Bom!";

        String requestBody = "{\"restaurantId\":\"" + restaurantId + "\",\"userId\":\"" + userId + "\",\"rating\":\"" + rating + "\",\"comment\":\"" + comment + "\"}";
        return requestBody;
    }
}
