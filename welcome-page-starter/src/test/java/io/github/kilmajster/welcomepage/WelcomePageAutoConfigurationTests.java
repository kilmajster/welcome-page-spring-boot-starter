package io.github.kilmajster.welcomepage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import welcomePage.BootstrapWelcomePage;
import welcomePage.CleanWelcomePage;
import welcomePage.MaterialWelcomePage;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = WelcomePageAutoConfiguration.class)
class WelcomePageAutoConfigurationTests {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(WelcomePageAutoConfiguration.class));

    @Test
    public void shouldNotInstanceWelcomePageController_whenWelcomePageConfigIsNotPresent() {
        this.contextRunner.run((context) -> assertThat(context).doesNotHaveBean(WelcomePageController.class));
    }

    @Test
    public void shouldInstanceWelcomePageController_whenWelcomePageConfigurationIsPresent() {
        this.contextRunner
                .withBean(WelcomePage.class)
                .run((context) -> assertThat(context).hasSingleBean(WelcomePageController.class));
    }

    @Test
    public void shouldInstanceWelcomePageController_whenBootstrapWelcomePageIsPresent() {
        this.contextRunner
                .withBean(BootstrapWelcomePage.class)
                .run((context) -> assertThat(context).hasSingleBean(WelcomePageController.class));
    }

    @Test
    public void shouldInstanceWelcomePageController_whenMaterialWelcomePageIsPresent() {
        this.contextRunner
                .withBean(MaterialWelcomePage.class)
                .run((context) -> assertThat(context).hasSingleBean(WelcomePageController.class));
    }

    @Test
    public void shouldInstanceWelcomePageController_whenCleanWelcomePageIsPresent() {
        this.contextRunner
                .withBean(CleanWelcomePage.class)
                .run((context) -> assertThat(context).hasSingleBean(WelcomePageController.class));
    }
}