package ardi.springintro.controller;

import ardi.springintro.SpringIntroApplication;
import ardi.springintro.model.Spaceship;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringIntroApplication.class)
@AutoConfigureWebTestClient
class SpaceshipsControllerTest {

    @Autowired
    WebTestClient client;

    static MockWebServer mockWebServer;

    @BeforeAll
    static void beforeAll() throws Exception{
        mockWebServer = new MockWebServer();
        mockWebServer.start(10001);

        mockWebServer.setDispatcher(new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest recordedRequest) throws InterruptedException {
                MockResponse mockResponse = new MockResponse();
                mockResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                mockResponse.setResponseCode(200);

                String jsonFilePath = "";
                if (recordedRequest.getPath().equals("/starships")) {
                    jsonFilePath = "src/test/resources/jsonResponse/SpaceshipsResponse.json";
                }
                else {
                    jsonFilePath = "src/test/resources/jsonResponse/SpaceshipResponse.json";
                }

                try {
                    FileInputStream fileInputStream = new FileInputStream(jsonFilePath);
                    String content = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());
                    mockResponse.setBody(content);
                } catch (Exception e) {
                    System.out.println("ERRORRR" + e.getMessage());
                }
                return mockResponse;
            }
        });
    }

    @AfterAll
    public static void afterAll() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    void getSpaceships() {
        List<Spaceship> response = client.get()
                .uri("/spaceships")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<List<Spaceship>>() {})
                .returnResult()
                .getResponseBody();

        assertNotNull(response);
        assertTrue(response.size() > 0);
        assertEquals("CR90 corvette", response.get(0).getName());
        assertEquals("Star Destroyer", response.get(1).getName());
    }

    @Test
    void getSpaceship() {
        Spaceship response = client.get()
                .uri("/spaceships/1")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<Spaceship>() {})
                .returnResult()
                .getResponseBody();

        assertNotNull(response);
        assertEquals("CR90 corvette", response.getName());
    }
}