package br.com.fiap.techChallenge3.usecase.customer;

import br.com.fiap.techChallenge3.entity.customer.exception.CustomerNotFoundException;
import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.usecase.customer.dto.ICustomerUpdateData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UpdateCustomerUseCaseTest {

    private CustomerGateway customerGateway;
    private UpdateCustomerUseCase updateCustomerUseCase;

    @BeforeEach
    public void setUp() {
        customerGateway = mock(CustomerGateway.class);
        updateCustomerUseCase = new UpdateCustomerUseCase(customerGateway);
    }

    @Test
    public void testExecuteUpdatesCustomerWhenIdIsValid() throws CustomerNotFoundException {
        Long customerId = 1L;
        ICustomerUpdateData updateData = mock(ICustomerUpdateData.class);
        Customer existingCustomer = new Customer("danizin", "1234", "Daniel Martins", "daniel@example.com", "54878912354", "56619973");
        when(customerGateway.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(updateData.username()).thenReturn("danizin");
        when(updateData.password()).thenReturn("1234");
        when(updateData.name()).thenReturn("Daniel Martins");
        when(updateData.email()).thenReturn("daniel@example.com");
        when(updateData.cpf()).thenReturn("54878912354");
        when(updateData.phoneNumber()).thenReturn("56619973");

        Customer updatedCustomer = updateCustomerUseCase.execute(customerId, updateData);

        assertEquals("danizin", updatedCustomer.getUsername());
        assertEquals("1234", updatedCustomer.getPassword());
        assertEquals("Daniel Martins", updatedCustomer.getName());
        assertEquals("daniel@example.com", updatedCustomer.getEmail());
        assertEquals("54878912354", updatedCustomer.getCpf());
        assertEquals("56619973", updatedCustomer.getPhoneNumber());
        verify(customerGateway, times(1)).update(existingCustomer);
    }

    @Test
    public void testExecuteThrowsExceptionWhenCustomerNotFound() {
        Long customerId = 1L;
        ICustomerUpdateData updateData = mock(ICustomerUpdateData.class);
        when(customerGateway.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> updateCustomerUseCase.execute(customerId, updateData));
        verify(customerGateway, never()).update(any());
    }
}
