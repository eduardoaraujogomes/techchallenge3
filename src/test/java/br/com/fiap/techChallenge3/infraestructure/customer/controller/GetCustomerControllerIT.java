package br.com.fiap.techChallenge3.infraestructure.customer.controller;

import br.com.fiap.techChallenge3.infraestructure.reservation.controller.CreateReservationControllerIT;
import br.com.fiap.techChallenge3.infraestructure.restaurant.controller.CreateRestaurantControllerIT;
import br.com.fiap.techChallenge3.utils.Config;
import br.com.fiap.techChallenge3.utils.ReservationHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class GetCustomerControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/customers/{id}";

    ReservationHelper reservationHelper = new ReservationHelper();

    @BeforeAll
    public static void setup(){
      CreateCustomerControllerIT customerControllerIT = new CreateCustomerControllerIT();
      customerControllerIT.shouldCreateCustomerSucess();
    }

    @Test
    public void shouldGetReservationIdSuccessfully(){
        int customerId = 1;

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(reservationHelper.bodyRequestReservation())
                .pathParam("id", customerId)
                .when()
                .get()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body("id", not(empty()))
                .body("username", equalTo( "Pedro" ))
                .body("cpf", equalTo("35598678421"))
                .body("phoneNumber", equalTo("3196358472"))
                .body("password", not(empty()))
                .body("email", not(empty()));

    }
}