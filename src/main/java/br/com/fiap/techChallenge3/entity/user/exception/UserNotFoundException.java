package br.com.fiap.techChallenge3.entity.user.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("Usuário não encontrado!");
    }
}
