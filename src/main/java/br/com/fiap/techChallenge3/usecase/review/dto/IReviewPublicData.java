package br.com.fiap.techChallenge3.usecase.review.dto;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

import java.time.LocalTime;

public interface IReviewPublicData {
    Long id();

    Restaurant restaurant();

    Long userId();

    Double rating();

    String comment();

}
