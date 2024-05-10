package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateCustomerUseCaseTest {

    private CreateCustomerUseCase createCustomerUseCase;
    private CustomerGateway customerGateway;
    private ICustomerRegistrationData registrationData;

    @BeforeEach
    public void setup() {
        customerGateway = mock(CustomerGateway.class);
        createCustomerUseCase = new CreateCustomerUseCase(customerGateway);
        registrationData = mock(ICustomerRegistrationData.class);
    }

    @Test
    public void shouldCreateCustomerWhenRequestIsValid() {
        when(registrationData.username()).thenReturn("danizin");
        when(registrationData.password()).thenReturn("1234");
        when(registrationData.name()).thenReturn("Daniel Martins");
        when(registrationData.email()).thenReturn("daniel@example.com");
        when(registrationData.cpf()).thenReturn("54878912354");
        when(registrationData.phoneNumber()).thenReturn("56619973");

        Customer expectedCustomer = new Customer("danizin", "1234", "Daniel Martins", "daniel@example.com", "54878912354", "56619973");

        when(customerGateway.create(any(Customer.class))).thenReturn(expectedCustomer);

        Customer createdCustomer = createCustomerUseCase.execute(registrationData);

        assertNotNull(createdCustomer);
        assertEquals(expectedCustomer, createdCustomer);
        verify(customerGateway, times(1)).create(any(Customer.class));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionCreateCustomerWhenRequestIsNotValid() {
        assertThrows(IllegalArgumentException.class, () -> createCustomerUseCase.execute(null));
        verify(customerGateway, never()).create(any(Customer.class));
    }
}
