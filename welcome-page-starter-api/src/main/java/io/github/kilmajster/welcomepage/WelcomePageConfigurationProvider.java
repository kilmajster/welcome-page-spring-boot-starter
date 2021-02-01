package io.github.kilmajster.welcomepage;


public interface WelcomePageConfigurationProvider {
    String getTitle();
    String getMarkdown();
    WelcomePage.Style getStyle();
}
