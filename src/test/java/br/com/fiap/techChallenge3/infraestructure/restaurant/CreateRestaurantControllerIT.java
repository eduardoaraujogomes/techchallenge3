package br.com.fiap.techChallenge3.infraestructure.restaurant;

import br.com.fiap.techChallenge3.utils.Config;
import br.com.fiap.techChallenge3.utils.RestaurantHelper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CreateRestaurantControllerIT {
    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/restaurants";
    RestaurantHelper restaurantHelper = new RestaurantHelper();
    @Test
    public void deveCriarRestaurantComSucesso(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantHelper.bodyRequestRestaurant())
                .when()
                .post()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body("id", not(empty()))
                .body("name", not(empty()))
                .body("location", not(empty()))
                .body("cuisineType", not(empty()))
                .body("openingHours", not(empty()))
                .body("capacity", not(empty()));
    }

    @Test
    public void deveValidarSchemaResponseRestaurant(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantHelper.bodyRequestRestaurant())
                .when()
                .post()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath( "schema/restaurant-schema.json" ));
    }
}
