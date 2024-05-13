package br.com.fiap.techChallenge3.utils;

import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewRegistrationData;

public class ReviewHelper {

    public String bodyRequestReview(){


        Integer restaurantId = 1;
        Integer userId = 1;
        String rating = "3.0";
        String comment = "Muito Bom!";

        String requestBody = "{\"restaurantId\":\"" + restaurantId + "\",\"userId\":\"" + userId + "\",\"rating\":\"" + rating + "\",\"comment\":\"" + comment + "\"}";
        return requestBody;
    }

    public static ReviewRegistrationData gerarReviewRequest() {
        return ReviewRegistrationData.builder()
                .restaurantId(1L)
                .userId(1L)
                .rating(10.0)
                .comment("excelente")
                .build();
    }

}
