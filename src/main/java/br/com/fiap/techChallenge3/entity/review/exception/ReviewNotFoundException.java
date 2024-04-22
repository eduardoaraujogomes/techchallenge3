package br.com.fiap.techChallenge3.entity.review.exception;

public class ReviewNotFoundException extends Exception{
    public ReviewNotFoundException(){
        super("Review não encontrado!");
    }
}
