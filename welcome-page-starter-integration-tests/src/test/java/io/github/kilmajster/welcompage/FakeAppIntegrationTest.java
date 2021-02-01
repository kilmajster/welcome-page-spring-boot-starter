package io.github.kilmajster.welcompage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(
        classes = WelcomePageFakeApp.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FakeAppIntegrationTest {

    private final RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("http://localhost:8080")
            .build();

    @Test
    public void http200() {
        final ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
