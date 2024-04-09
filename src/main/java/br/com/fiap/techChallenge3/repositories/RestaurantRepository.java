package br.com.fiap.techChallenge3.repositories;

import br.com.fiap.techChallenge3.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
