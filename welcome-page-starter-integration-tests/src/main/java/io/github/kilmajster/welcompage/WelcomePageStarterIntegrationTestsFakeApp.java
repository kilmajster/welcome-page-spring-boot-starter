package io.github.kilmajster.welcompage;

import io.github.kilmajster.welcomepage.WelcomePage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static io.github.kilmajster.welcomepage.WelcomePage.loadedFrom;

@SpringBootApplication
public class WelcomePageStarterIntegrationTestsFakeApp {

    public static void main(String[] args) {
        SpringApplication.run(WelcomePageStarterIntegrationTestsFakeApp.class, args);
    }

    @Bean
    public WelcomePage welcomePage() {
        return new WelcomePage()
                .withTitle("🍕 Sample welcome page")
                .withMarkdown(loadedFrom("https://raw.githubusercontent.com/kilmajster/welcome-page-spring-boot-starter/main/README.md"))
                .withStyle(WelcomePage.Style.PRETTIFY_MATERIAL_DESIGN);
    }

}