package br.com.fiap.techChallenge3.infraestructure.config.db.repository;

import br.com.fiap.techChallenge3.infraestructure.config.db.schema.ReservationSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationSchema, Long> {

    List<ReservationSchema> findAllByCustomerId(Long customerId);

//    List<ReservationSchema> findAllByRestaurantId(Long restaurantId);
}
