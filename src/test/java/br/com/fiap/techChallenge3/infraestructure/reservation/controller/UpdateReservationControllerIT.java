package br.com.fiap.techChallenge3.infraestructure.reservation.controller;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.infraestructure.customer.controller.CreateCustomerControllerIT;
import br.com.fiap.techChallenge3.infraestructure.restaurant.controller.CreateRestaurantControllerIT;
import br.com.fiap.techChallenge3.utils.Config;
import br.com.fiap.techChallenge3.utils.ReservationHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class UpdateReservationControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/reservations/{id}";
    ReservationHelper reservationHelper = new ReservationHelper();

    @BeforeAll
    public static void setup(){
        CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
        createRestaurantControllerIT.shouldCreateRestaurantSucess();
        CreateCustomerControllerIT createCustomerControllerIT = new CreateCustomerControllerIT();
        createCustomerControllerIT.shouldCreateCustomerSucess();
        CreateReservationControllerIT createReservationControllerIT = new CreateReservationControllerIT();
        createReservationControllerIT.shouldCreateReservationSucess();
    }

    @Test
    public void shouldUpdateReservationIdSuccessfully(){
        int reservationId = 1;

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body( reservationHelper.bodyRequestReservationUpdate() )
                .pathParam("id", reservationId)
                .when()
                .put()
                .then()
                .statusCode( HttpStatus.OK.value())
                .body("id", not(empty()))
                .body("hour", equalTo( "23:00" ))
                .body("date", equalTo("05/12/2024"))
                .body("restaurant.id", not(empty()))
                .body("restaurant.name", not(empty()))
                .body("restaurant.location",  equalTo("Industrial"))
                .body("restaurant.cuisineType",  equalTo("Brasileira"))
                .body("restaurant.openingHours",  equalTo("20:00:00"))
                .body("restaurant.capacity",  not(empty()))
                .body("customer.id", not(empty()))
                .body("customer.username", not(empty()))
                .body("customer.name", not(empty()))
                .body("customer.email", not(empty()))
                .body("customer.phoneNumber", not(empty()))
                .body("status", equalTo( "CONFIRMED"));

    }
}