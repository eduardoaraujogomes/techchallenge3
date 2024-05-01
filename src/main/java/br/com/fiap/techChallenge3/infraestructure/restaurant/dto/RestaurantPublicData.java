package br.com.fiap.techChallenge3.infraestructure.restaurant.dto;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.entity.review.model.Review;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationPublicData;
import br.com.fiap.techChallenge3.infraestructure.review.dto.ReviewPublicData;
import br.com.fiap.techChallenge3.usecase.restaurant.dto.IRestaurantPublicData;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public record RestaurantPublicData(
        Long id,
        String name,
        String location,
        String cuisineType,
        LocalTime openingHours,
        Integer capacity,
        List<ReviewPublicData> reviews,
        List<ReservationPublicData> reservations)

        implements IRestaurantPublicData {
    public RestaurantPublicData(Restaurant restaurant){
        this(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLocation(),
                restaurant.getCuisineType(),
                restaurant.getOpeningHours(),
                restaurant.getCapacity(),
                convertReviewsToPublicData(restaurant.getReviews()),
                convertReservationsToPublicData(restaurant.getReservations()));
    }
    private static List<ReviewPublicData> convertReviewsToPublicData(List<Review> reviews) {
        List<ReviewPublicData> publicReviews = new ArrayList<>();
        for (Review review : reviews) {
            ReviewPublicData publicData = new ReviewPublicData(review);
            publicReviews.add(publicData);
        }
        return publicReviews;
    }

    private static List<ReservationPublicData> convertReservationsToPublicData(List<Reservation> reservations) {
        List<ReservationPublicData> publicReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ReservationPublicData publicData = new ReservationPublicData(reservation);
            publicReservations.add(publicData);
        }
        return publicReservations;
    }
}
