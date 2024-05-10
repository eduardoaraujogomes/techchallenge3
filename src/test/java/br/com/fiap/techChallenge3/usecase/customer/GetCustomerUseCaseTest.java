package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetCustomerUseCaseTest {

    private GetCustomerUseCase getCustomerUseCase;
    private CustomerGateway customerGateway;
    private static final Long EXISTING_CUSTOMER_ID = 123L;
    private static final Long NON_EXISTING_CUSTOMER_ID = 456L;

    @BeforeEach
    public void setup() {
        customerGateway = mock(CustomerGateway.class);
        getCustomerUseCase = new GetCustomerUseCase(customerGateway);
    }

    @Test
    public void shoudGetCustomer() {
        Customer customer = new Customer("danizin", "1234", "Daniel Martins", "daniel@example.com", "54878912354", "56619973");
        customer.setId(EXISTING_CUSTOMER_ID);

        when(customerGateway.findById(EXISTING_CUSTOMER_ID)).thenReturn(Optional.of(customer));


        Customer resultCustomer = getCustomerUseCase.execute(EXISTING_CUSTOMER_ID);

        assertNotNull(resultCustomer);
        assertEquals(customer, resultCustomer);
        verify(customerGateway, times(1)).findById(EXISTING_CUSTOMER_ID);
    }

    @Test
    public void shoudThrowCustomerNotFoundException() {
        when(customerGateway.findById(NON_EXISTING_CUSTOMER_ID)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> getCustomerUseCase.execute(NON_EXISTING_CUSTOMER_ID));
        verify(customerGateway, times(1)).findById(NON_EXISTING_CUSTOMER_ID);
    }
}
