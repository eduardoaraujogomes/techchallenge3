package br.com.fiap.techChallenge3.infraestructure.config.db.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
public abstract class UserSchema extends AbstractEntitySchema<Long> {

    @NotBlank
    @Column(length = 20, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false, length = 40, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 64)
    private String password;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String name;

    public UserSchema(Long id, String username, String name, String email, String password) {
        this.setId(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;

    }

    public UserSchema() {
    }
}
