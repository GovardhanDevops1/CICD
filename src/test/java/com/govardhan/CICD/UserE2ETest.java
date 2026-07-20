package com.govardhan.CICD;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;

@SpringBootTest(
    classes = Application.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class UserE2ETest {

    @LocalServerPort
    int port;

    @Test
    void testGetUserE2E() {
        RestAssured.port = port;

        RestAssured
            .given()
            .when()
            .get("/users/1")
            .then()
            .statusCode(200);
    }
}

