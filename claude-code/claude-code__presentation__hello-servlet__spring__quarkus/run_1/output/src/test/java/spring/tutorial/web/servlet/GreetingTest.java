package spring.tutorial.web.servlet;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingTest {

    @Test
    void testGreetingEndpoint() {
        given()
            .queryParam("name", "World")
            .when().get("/greeting")
            .then()
            .statusCode(200)
            .body(is("Hello, World!"));
    }

    @Test
    void testRootReturnsOk() {
        given()
            .when().get("/")
            .then()
            .statusCode(200);
    }
}
