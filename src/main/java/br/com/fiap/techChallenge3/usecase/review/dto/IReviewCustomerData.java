package br.com.fiap.techChallenge3.usecase.review.dto;

import br.com.fiap.techChallenge3.infraestructure.restaurant.dto.RestaurantCustomerData;

public interface IReviewCustomerData {

    Long id();

    Double rating();

    String comment();

    RestaurantCustomerData restaurant();
}
