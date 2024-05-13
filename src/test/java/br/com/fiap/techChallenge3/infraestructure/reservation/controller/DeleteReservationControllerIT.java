package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.infraestructure.customer.controller.CreateCustomerControllerIT;
import br.com.fiap.techChallenge3.infraestructure.restaurant.controller.CreateRestaurantControllerIT;
import br.com.fiap.techChallenge3.utils.Config;
import br.com.fiap.techChallenge3.utils.ReservationHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

class DeleteReservationControllerIT {
    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/reservations/{id}";
    ReservationHelper reservationHelper = new ReservationHelper();

    @BeforeAll
    public static void setUp() throws InterruptedException {
        CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
        createRestaurantControllerIT.shouldCreateRestaurantSucess();
        CreateCustomerControllerIT createCustomerControllerIT = new CreateCustomerControllerIT();
        createCustomerControllerIT.shouldCreateCustomerSucess();
        CreateReservationControllerIT createReservationControllerIT = new CreateReservationControllerIT();
        createReservationControllerIT.shouldCreateReservationSucess();
    }

    @Test
    public void shouldDeleteRestaurantSuccess() {
        int reservationId = 1;


        String responseBody = given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(reservationHelper.bodyRequestReservation())
                .pathParam("id", reservationId)
                .when()
                .delete()
                .then()
                .statusCode( HttpStatus.OK.value())
                .extract().asString();

        assertThat(responseBody, emptyString());
    }
}