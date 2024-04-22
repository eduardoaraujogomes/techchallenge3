package br.com.fiap.techChallenge3.entity.restaurant.gateway;

import br.com.fiap.techChallenge3.entity.reservation.model.Reservation;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantGateway {
    Restaurant create(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
    void delete(Long id);
    Optional<Restaurant> findByName (String restaurant);
    List<Restaurant> findByCuisine (String restaurant);
    List<Restaurant> findByLocation (String restaurant);
    List<Restaurant> findAll();
}
