package service;
import entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        if (reviewRepository.existsById(id)) {
            updatedReview.setId(id);
            return reviewRepository.save(updatedReview);
        }
        return null;
    }
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}