package br.com.fiap.techChallenge3.usecase.review.dto;

import br.com.fiap.techChallenge3.infraestructure.customer.dto.CustomerPublicData;
import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantPublicData;

public interface IReviewPublicData {
    Long id();

    RestaurantPublicData restaurant();

    CustomerPublicData customer();

    Double rating();

    String comment();

}
