package io.github.kilmajster.welcomepage;

import lombok.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@AllArgsConstructor
@Data
@NoArgsConstructor
@With
public class WelcomePage {
    private String title; // it means this tittle - <html><head><title>Dummy title</title> ...
    private String markdown; // text taht will
    private Style style = Style.CLEAN;

    @RequiredArgsConstructor
    public enum Style {
        CLEAN(false),
        BOOTSTRAP(false), // https://getbootstrap.com/docs/5.0/getting-started/introduction/
        MATERIAL_DESIGN(false), // https://mdbootstrap.com/md-bootstrap-cdn/
        PRETTIFY_BOOTSTRAP(true),
        PRETTIFY_MATERIAL_DESIGN(true),
        ;

        @Getter
        private final boolean prettify; // enabling jumbotron, center of things etc ...
    }

    /**
     * Loads url to string.
     */
    @SneakyThrows
    public static String loadedFrom(final String url){
        return IOUtils.toString(new URL(url), Charset.defaultCharset());
    }
}