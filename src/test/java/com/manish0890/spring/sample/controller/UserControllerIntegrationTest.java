package com.manish0890.spring.sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manish0890.spring.sample.TestDataCleanup;
import com.manish0890.spring.sample.persistance.document.User;
import com.manish0890.spring.sample.persistance.service.UserESService;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.manish0890.spring.sample.TestUtility.getSampleUser;
import static com.manish0890.spring.sample.constants.RequestMappingConstants.User.USER;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest extends TestDataCleanup {

    @Value("${local.server.port}")
    private int port;

    @Value("${server.servlet.context-path}")
    private String basePath;

    @Autowired
    private UserESService userESService;

    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
        RestAssured.basePath = basePath;

        mapper = new ObjectMapper();
    }

    @Test
    void testCreateApi() throws JsonProcessingException {

        // Create test data
        User expectedUser = getSampleUser();

        // Execute the method under test
        ExtractableResponse<Response> response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(mapper.writeValueAsString(expectedUser))
                .post(USER)
                .then().statusCode(HttpStatus.CREATED.value()).extract();

        User actualUser = mapper.readValue(response.response().asString(), User.class);

        // Assertions
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testReadApi() throws JsonProcessingException {
        // Create Test Data
        User expectedUser = getSampleUser();
        userESService.create(expectedUser);
        assertNotNull(expectedUser.getId());

        // Execute the method under test
        ExtractableResponse<Response> response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get(USER + "/" + expectedUser.getId())
                .then().statusCode(HttpStatus.OK.value())
                .extract();

        User actualUser = mapper.readValue(response.response().asString(), User.class);

        // Assertions
        assertEquals(expectedUser, actualUser);
    }
}
