package br.com.fiap.techChallenge3.usecase.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

public interface IReviewtRegistrationData {

    Restaurant restaurant();

    Long userId();

    Double rating();

    String comment();
}
