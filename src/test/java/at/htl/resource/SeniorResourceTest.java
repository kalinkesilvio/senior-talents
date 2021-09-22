package at.htl.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class SeniorResourceTest {

    @Test
    public void testList() {
        given()
                .when().get("/seniors")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "email", containsInAnyOrder("bertl.broame@gmail.com", "gustav.jauk@aon.com"),
                        "password", containsInAnyOrder("bertl123", "ungustl321"));
    }

    @Test
    public void testAdd() {
        given()
                .body("{\"email\": \"rudolf.r@gmail.com\", \"password\": \"rudi\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/seniors")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "email", containsInAnyOrder("bertl.broame@gmail.com", "gustav.jauk@aon.com", "rudolf.r@gmail.com"),
                        "password", containsInAnyOrder("bertl123", "ungustl321", "rudi"));

        given()
                .body("{\"email\": \"rudolf.r@gmail.com\", \"password\": \"rudi\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/seniors")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "email", containsInAnyOrder("bertl.broame@gmail.com", "gustav.jauk@aon.com"),
                        "password", containsInAnyOrder("bertl123", "ungustl321"));
    }
}