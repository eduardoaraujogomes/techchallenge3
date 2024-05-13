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
import static org.hamcrest.Matchers.*;

public class SearchReservationControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/reservations";

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
    public void shouldGetReservationAllSuccessfully(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(reservationHelper.bodyRequestReservation())
                .when()
                .get()
                .then()
                .statusCode( HttpStatus.OK.value())
                .body("id[0]", not(empty()))
                .body("hour[0]", equalTo( "22:00" ))
                .body("date[0]", equalTo("04/12/2024"))
                .body("restaurant[0].id", not(empty()))
                .body("restaurant[0].name", not(empty()))
                .body("restaurant[0].location",  equalTo("Industrial"))
                .body("restaurant[0].cuisineType",  equalTo("Brasileira"))
                .body("restaurant[0].openingHours",  equalTo("20:00:00"))
                .body("restaurant[0].capacity",  not(empty()))
                .body("customer[0].id", not(empty()))
                .body("customer[0].username", not(empty()))
                .body("customer[0].name", not(empty()))
                .body("customer[0].email", not(empty()))
                .body("customer[0].phoneNumber", not(empty()))
                .body("status[0]", equalTo( "CONFIRMED"));

    }
}
