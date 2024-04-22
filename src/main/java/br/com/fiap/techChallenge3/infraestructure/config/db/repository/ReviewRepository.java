package br.com.fiap.techChallenge3.infraestructure.config.db.repository;

import br.com.fiap.techChallenge3.entity.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
