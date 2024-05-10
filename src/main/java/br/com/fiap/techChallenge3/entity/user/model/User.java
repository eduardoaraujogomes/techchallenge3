package br.com.fiap.techChallenge3.entity.user.model;

import br.com.fiap.techChallenge3.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User extends AbstractEntity<Long> {

    private String username;
    private String email;
    private String password;
    private String name;

}

