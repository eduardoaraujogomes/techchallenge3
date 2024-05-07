package br.com.fiap.techChallenge3.infraestructure.customer.gateway;

import br.com.fiap.techChallenge3.entity.customer.gateway.CustomerGateway;
import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.CustomerRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.CustomerSchema;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.ReservationSchema;

import java.util.List;
import java.util.Optional;

public class CustomerDatabaseGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;

    public CustomerDatabaseGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer create(final Customer customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();

    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository
                .findById(id)
                .map(CustomerSchema::toCustomerWithFullInformation);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream().map(CustomerSchema::toCustomer).toList();
    }
}
