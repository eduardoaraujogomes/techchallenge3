package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeleteCustomerUseCaseTest {

    private DeleteCustomerUseCase deleteCustomerUseCase;
    private CustomerGateway customerGateway;
    private static final Long CUSTOMER_ID = 123L;

    @BeforeEach
    public void setup() {
        customerGateway = mock(CustomerGateway.class);
        deleteCustomerUseCase = new DeleteCustomerUseCase(customerGateway);
    }

    @Test
    public void shouldDeleteCustomerWhenCustomerIdIsValid() {
        Customer customer = new Customer("danizin", "1234", "Daniel Martins", "daniel@example.com", "54878912354", "56619973");
        customer.setId(CUSTOMER_ID);

        when(customerGateway.findById(CUSTOMER_ID)).thenReturn(Optional.of(customer));

        deleteCustomerUseCase.execute(CUSTOMER_ID);

        verify(customerGateway, times(1)).findById(CUSTOMER_ID);
        verify(customerGateway, times(1)).delete(CUSTOMER_ID);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenCustomerIdIsInvalid() {
        when(customerGateway.findById(CUSTOMER_ID)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> deleteCustomerUseCase.execute(CUSTOMER_ID));
        verify(customerGateway, times(1)).findById(CUSTOMER_ID);
        verify(customerGateway, never()).delete(anyLong());
    }
}
