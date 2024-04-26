package br.com.fiap.techChallenge3.infraestructure.config.web;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.CustomerRepository;
import br.com.fiap.techChallenge3.infraestructure.reservation.gateway.CustomerDatabaseGateway;
import br.com.fiap.techChallenge3.usecase.customer.CreateCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.DeleteCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.GetCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.SearchCustomerUseCase;
import br.com.fiap.techChallenge3.usecase.customer.UpdateCustomerUseCase;
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
}
