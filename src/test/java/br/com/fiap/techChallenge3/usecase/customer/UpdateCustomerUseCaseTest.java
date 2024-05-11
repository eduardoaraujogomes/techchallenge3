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
    public void shouldUpdatesCustomerWhenIdIsValid() throws CustomerNotFoundException {
        Long customerId = 1L;
        ICustomerUpdateData updateData = mock(ICustomerUpdateData.class);
        Customer customer = new Customer("danizin", "daniel@example.com", "1234", "Daniel Martins", "54878912354", "56619973");
        when(customerGateway.findById(customerId)).thenReturn(Optional.of(customer));
        when(updateData.username()).thenReturn("eduardo");
        when(updateData.password()).thenReturn("7894");
        when(updateData.name()).thenReturn("Eduardo Araujo");
        when(updateData.email()).thenReturn("eduardo@example.com");
        when(updateData.cpf()).thenReturn("54878912356");
        when(updateData.phoneNumber()).thenReturn("56619974");

        when(customerGateway.update(customer)).thenReturn(customer);

        Customer updatedCustomer = updateCustomerUseCase.execute(customerId, updateData);

        assertEquals("eduardo", updatedCustomer.getUsername());
        assertEquals("7894", updatedCustomer.getPassword());
        assertEquals("Eduardo Araujo", updatedCustomer.getName());
        assertEquals("eduardo@example.com", updatedCustomer.getEmail());
        assertEquals("54878912356", updatedCustomer.getCpf());
        assertEquals("56619974", updatedCustomer.getPhoneNumber());
        verify(customerGateway, times(1)).update(customer);
    }

    @Test
    public void shouldThrowsExceptionWhenCustomerNotFound() {
        Long customerId = 1L;
        ICustomerUpdateData updateData = mock(ICustomerUpdateData.class);
        when(customerGateway.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> updateCustomerUseCase.execute(customerId, updateData));
        verify(customerGateway, never()).update(any());
    }
}
