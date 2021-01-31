package io.github.kilmajster.welcomepage;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnBean(WelcomePage.class)
@Configuration
public class WelcomePageAutoConfiguration {

	@Bean
	public WelcomePageController welcomePageController(WelcomePage welcomePage) {
		return new WelcomePageController(welcomePage);
	}
}