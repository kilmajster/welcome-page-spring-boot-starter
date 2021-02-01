package io.github.kilmajster.welcompage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import welcomePage.MaterialWelcomePage;

@SpringBootApplication
public class WelcomePageFakeApp {

    public static void main(String[] args) {
        SpringApplication.run(WelcomePageFakeApp.class, args);
    }

    @Bean
    public MaterialWelcomePage welcomePage() {
        return new MaterialWelcomePage()
                .withTitle("🍕 Sample welcome page")
                .withMarkdownFrom("https://raw.githubusercontent.com/kilmajster/welcome-page-spring-boot-starter/main/README.md");
    }
}