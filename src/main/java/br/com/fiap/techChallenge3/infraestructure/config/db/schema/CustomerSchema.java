package br.com.fiap.techChallenge3.infraestructure.config.db.schema;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class CustomerSchema extends UserSchema {

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotBlank
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<ReservationSchema> reservations;

    public CustomerSchema(final Customer customer) {
        super(customer.getId(), customer.getUsername(), customer.getEmail(), customer.getPassword(),
                customer.getName());
        this.cpf = customer.getCpf();
        this.phoneNumber = customer.getPhoneNumber();
    }

    public CustomerSchema() {
        super();
    }

    public Customer toCustomer() {
        Customer customer = new Customer(
                this.getUsername(),
                this.getPassword(),
                this.getName(),
                this.getEmail(),
                this.cpf,
                this.phoneNumber
        );
        customer.setId(this.getId());
        return customer;
    }
}
