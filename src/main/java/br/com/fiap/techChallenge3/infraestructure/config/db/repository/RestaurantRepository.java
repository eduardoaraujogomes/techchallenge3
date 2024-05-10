package br.com.fiap.techChallenge3.infraestructure.config.db.repository;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.RestaurantSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantSchema, Long> {
    Optional<Restaurant> findByName (String name);
    List<Restaurant> findByCuisine (String cuisine);
    List<Restaurant> findByLocation (String location);
}
