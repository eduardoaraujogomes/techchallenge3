package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SearchCustomerUseCaseTest {

    private CustomerGateway customerGateway;
    private SearchCustomerUseCase searchCustomerUseCase;

    @BeforeEach
    public void setUp() {
        customerGateway = Mockito.mock(CustomerGateway.class);
        searchCustomerUseCase = new SearchCustomerUseCase(customerGateway);
    }

    @Test
    public void shouldReturnListOfCustomers() {
        Customer customer1 = new Customer("danizin", "1234", "Daniel Martins", "daniel@example.com", "54878912354", "56619973");
        Customer customer2 = new Customer("eduardo", "4564", "Eduardo Araujo", "eduardo@example.com", "54878912355", "56619974");

        List<Customer> expectedCustomers = Arrays.asList(
                customer1,
                customer2
        );
        when(customerGateway.findAll()).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = searchCustomerUseCase.execute();

        assertEquals(expectedCustomers, actualCustomers);
    }

    @Test
    public void shouldReturnEmptyListWhenNoCustomersFound() {
        List<Customer> expectedCustomers = Arrays.asList();
        when(customerGateway.findAll()).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = searchCustomerUseCase.execute();

        assertEquals(expectedCustomers, actualCustomers);
    }
}
