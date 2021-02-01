package io.github.kilmajster.welcomepage.util;

import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.youtube.embedded.YouTubeLinkExtension;
import com.vladsch.flexmark.html.AttributeProvider;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.IndependentAttributeProviderFactory;
import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class MarkdownParser {

    public static String toHtml(final String markdown) {
        final MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Arrays.asList(
                TablesExtension.create(),
                StrikethroughExtension.create(),
                YouTubeLinkExtension.create()));
        final Parser parser = Parser.builder(options).build();
        final HtmlRenderer renderer = HtmlRenderer.builder(options)
                .attributeProviderFactory(new IndependentAttributeProviderFactory() {
                    @Override
                    public @NotNull AttributeProvider apply(@NotNull LinkResolverContext linkResolverContext) {
                        return new MarkdownTablesBootstrapStylingFixer();
                    }
                }).build();

        return renderer.render(parser.parse(markdown));
    }
}