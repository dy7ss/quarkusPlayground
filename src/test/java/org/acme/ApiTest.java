package org.acme;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(SampleAResource.class)
public class ApiTest {
    @Test
    public void testHelloEndpoint() {
        given().when()
                .log().all()
                .get("/hello")
                .then()
                .log().all()
                .statusCode(200)
                .body(is("hello"));

    }

}
