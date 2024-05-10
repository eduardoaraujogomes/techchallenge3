package br.com.fiap.techChallenge3.usecase.review.dto;

public interface IReviewRegistrationData {

    Long restaurantId();

    Long userId();

    Double rating();

    String comment();
}
