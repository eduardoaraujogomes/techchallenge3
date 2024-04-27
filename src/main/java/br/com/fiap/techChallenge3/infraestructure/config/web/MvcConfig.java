package br.com.fiap.techChallenge3.infraestructure.config.web;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.reservation.gateway.ReservationGateway;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.CustomerRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReservationRepository;
import br.com.fiap.techChallenge3.infraestructure.customer.gateway.CustomerDatabaseGateway;
import br.com.fiap.techChallenge3.infraestructure.reservation.gateway.ReservationDatabaseGateway;
import br.com.fiap.techChallenge3.usecase.customer.*;
import br.com.fiap.techChallenge3.usecase.reservation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

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
    public CreateReservationUseCase createReservationUseCase(ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        ReservationGateway reservationGateway = new ReservationDatabaseGateway(reservationRepository);
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new CreateReservationUseCase(customerGateway, reservationGateway);
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
