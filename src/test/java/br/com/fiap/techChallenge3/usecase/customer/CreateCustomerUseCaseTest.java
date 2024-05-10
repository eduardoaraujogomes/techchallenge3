package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCustomerUseCaseTest {

    private CustomerGateway customerGateway;
    private CreateCustomerUseCase createCustomerUseCase;

    @BeforeEach
    public void setUp() {
        customerGateway = mock(CustomerGateway.class);
        createCustomerUseCase = new CreateCustomerUseCase(customerGateway);
    }

    @Test
    public void deveCriarCustomerComSucessoTest() {

        ICustomerRegistrationData request = mock(ICustomerRegistrationData.class);
        when(request.username()).thenReturn("augusto.junior");
        when(request.password()).thenReturn("123password");
        when(request.name()).thenReturn("Augusto Junior");
        when(request.email()).thenReturn("augusto@junior.com");
        when(request.cpf()).thenReturn("46339814042");
        when(request.phoneNumber()).thenReturn("1132659848");

        Customer createdCustomer = new Customer("augusto.junior", "augusto@junior.com", "123password", "augusto@junior.com", "46339814042", "1132659848");
        when(customerGateway.create(any(Customer.class))).thenReturn(createdCustomer);

        Customer result = createCustomerUseCase.execute(request);

        assertEquals(createdCustomer, result);
        verify(customerGateway, times(1)).create(any(Customer.class));
    }
}
