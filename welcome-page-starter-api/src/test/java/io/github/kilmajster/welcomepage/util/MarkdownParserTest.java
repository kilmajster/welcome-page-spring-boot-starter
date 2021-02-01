package io.github.kilmajster.welcomepage.util;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownParserTest {

    private static final String EXPECTED_HTML = "<h1>dummy h1</h1>\n";

    @Test
    public void shouldConvertToHtml() {
        final String html = MarkdownParser.toHtml("# dummy h1");

        assertThat(html).isEqualTo(EXPECTED_HTML);
    }
}