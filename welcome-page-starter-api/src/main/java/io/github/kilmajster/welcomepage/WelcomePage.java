package io.github.kilmajster.welcomepage;

import lombok.*;
import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.nio.charset.Charset;

@AllArgsConstructor
@Data
@NoArgsConstructor
@With
public class WelcomePage implements WelcomePageConfigurationProvider {

    private String title; // it means this tittle - <html><head><title>Dummy title</title> ...
    private String markdown; // text that will be converted from md to html
    private Style style;

    public enum Style {
        CLEAN,
        BOOTSTRAP, // https://getbootstrap.com/docs/5.0/getting-started/introduction/
        MATERIAL_DESIGN, // https://mdbootstrap.com/md-bootstrap-cdn/
        ;
    }

    /**
     * Loads url to string.
     */
    @SneakyThrows
    public static String loadFromUrl(final String url) {
        return IOUtils.toString(new URL(url), Charset.defaultCharset());
    }
}