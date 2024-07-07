package org.acme;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
// @TestHTTPEndpoint(SampleAResource.class)
public class ApiTest {
    @Test
    // @Timeout(value = 10000)
    public void testHelloEndpoint() {

        given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.socket.timeout", 1000000))) // 10秒に設定
                .when()
                .log().all()
                .get("hogehoge-service/hogehoge-service/sampleA/hello")
                .then()
                .log().all()
                .statusCode(200);
        // .body(is("hello"));

    }

}
