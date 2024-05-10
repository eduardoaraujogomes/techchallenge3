package br.com.fiap.techChallenge3.entity.review.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException() {
        super("Review não encontrado!");
    }
}
