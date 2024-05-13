
package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.utils.ReviewHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"/clean.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CreateReviewControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void devePermitirCriarReview() {

        var reviewRequest = ReviewHelper.gerarReviewRequest();
        given()
                .filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(reviewRequest)
                .when()
                .post("/reviews")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("$", hasKey("restaurantId"))
                .body("$", hasKey("userId"))
                .body("$", hasKey("rating"))
                .body("$", hasKey("comment"))
                .body("restaurantId", equalTo(reviewRequest.restaurantId()))
                .body("userId", equalTo(reviewRequest.userId()))
                .body("rating", equalTo(reviewRequest.rating()))
                .body("comment", equalTo(reviewRequest.comment()));
    }

}
