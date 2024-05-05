package br.com.fiap.techChallenge3.infraestructure.config.web;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.review.gateway.ReviewGateway;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.CustomerRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReservationRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.RestaurantRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReviewRepository;
import br.com.fiap.techChallenge3.infraestructure.customer.gateway.CustomerDatabaseGateway;
import br.com.fiap.techChallenge3.infraestructure.reservation.gateway.ReservationDatabaseGateway;
import br.com.fiap.techChallenge3.infraestructure.restaurant.gateway.RestaurantDatabaseGateway;
import br.com.fiap.techChallenge3.infraestructure.review.gateway.ReviewDatabaseGateway;
import br.com.fiap.techChallenge3.usecase.customer.CreateCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.DeleteCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.GetCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.SearchCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.UpdateCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.reservation.CreateReservationUseCase;
import br.com.fiap.techChallenge3.usecase.reservation.DeleteReservationUseCase;
import br.com.fiap.techChallenge3.usecase.reservation.GetReservationUseCase;
import br.com.fiap.techChallenge3.usecase.reservation.SearchReservationUseCase;
import br.com.fiap.techChallenge3.usecase.reservation.UpdateReservationUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.CreateRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.DeleteRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.SearchRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.UpdateRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.review.CreateReviewUseCase;
import br.com.fiap.techChallenge3.usecase.review.DeleteReviewUseCase;
import br.com.fiap.techChallenge3.usecase.review.GetReviewUseCase;
import br.com.fiap.techChallenge3.usecase.review.SearchReviewUseCase;
import br.com.fiap.techChallenge3.usecase.review.UpdateReviewUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateRestaurantUseCase createRestaurantUseCase(RestaurantRepository restaurantRepository) {
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new CreateRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public DeleteRestaurantUseCase deleteRestaurantUseCase(RestaurantRepository restaurantRepository) {
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new DeleteRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public GetRestaurantUseCase getRestaurantUseCase(RestaurantRepository restaurantRepository) {
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new GetRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public SearchRestaurantUseCase searchRestaurantUseCase(RestaurantRepository restaurantRepository) {
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new SearchRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public UpdateRestaurantUseCase updateRestaurantUseCase(RestaurantRepository restaurantRepository) {
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new UpdateRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public CreateReviewUseCase createReviewUseCase(ReviewRepository reviewRepository,
                                                   RestaurantRepository restaurantRepository,
                                                   CustomerRepository customerRepository) {
        ReviewGateway reviewGateway = new ReviewDatabaseGateway(reviewRepository);
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new CreateReviewUseCase(reviewGateway, restaurantGateway, customerGateway);
    }

    @Bean
    public DeleteReviewUseCase deleteRevewUseCase(ReviewRepository reviewRepository) {
        ReviewGateway reviewGateway = new ReviewDatabaseGateway(reviewRepository);
        return new DeleteReviewUseCase(reviewGateway);
    }

    @Bean
    public GetReviewUseCase getReviewUseCase(ReviewRepository reviewRepository) {
        ReviewGateway reviewGateway = new ReviewDatabaseGateway(reviewRepository);
        return new GetReviewUseCase(reviewGateway);
    }

    @Bean
    public SearchReviewUseCase searchReviewtUseCase(ReviewRepository reviewRepository) {
        ReviewGateway reviewGateway = new ReviewDatabaseGateway(reviewRepository);
        return new SearchReviewUseCase(reviewGateway);
    }

    @Bean
    public UpdateReviewUseCase updateReviewUseCase(ReviewRepository reviewRepository) {
        ReviewGateway reviewGateway = new ReviewDatabaseGateway(reviewRepository);
        return new UpdateReviewUseCase(reviewGateway);
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new CreateCustomerUseCase(customerGateway);
    }

    @Bean
    public GetCustomerUseCase getCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new GetCustomerUseCase(customerGateway);
    }

    @Bean
    public SearchCustomerUseCase searchCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new SearchCustomerUseCase(customerGateway);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new UpdateCustomerUseCase(customerGateway);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new DeleteCustomerUseCase(customerGateway);
    }

    @Bean
    public CreateReservationUseCase createReservationUseCase(ReservationRepository reservationRepository,
                                                             CustomerRepository customerRepository,
                                                             RestaurantRepository restaurantRepository) {
        ReservationGateway reservationGateway = new ReservationDatabaseGateway(reservationRepository);
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new CreateReservationUseCase(customerGateway, reservationGateway, restaurantGateway);
    }

    @Bean
    public DeleteReservationUseCase deleteReservationUseCase(ReservationRepository reservationRepository) {
        ReservationGateway reservationGateway = new ReservationDatabaseGateway(reservationRepository);
        return new DeleteReservationUseCase(reservationGateway);
    }

    @Bean
    public GetReservationUseCase getReservationUseCase(ReservationRepository reservationRepository) {
        ReservationGateway reservationGateway = new ReservationDatabaseGateway(reservationRepository);
        return new GetReservationUseCase(reservationGateway);
    }

    @Bean
    public SearchReservationUseCase searchReservationsUseCase(ReservationRepository reservationRepository) {
        ReservationGateway reservationGateway = new ReservationDatabaseGateway(reservationRepository);
        return new SearchReservationUseCase(reservationGateway);
    }

    @Bean
    public UpdateReservationUseCase updateReservationUseCase(ReservationRepository reservationRepository) {
        ReservationGateway reservationGateway = new ReservationDatabaseGateway(reservationRepository);
        return new UpdateReservationUseCase(reservationGateway);
    }
}
