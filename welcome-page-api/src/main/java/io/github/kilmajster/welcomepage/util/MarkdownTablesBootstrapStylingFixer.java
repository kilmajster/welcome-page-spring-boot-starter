package io.github.kilmajster.welcomepage.util;

import com.vladsch.flexmark.ext.tables.TableBlock;
import com.vladsch.flexmark.html.AttributeProvider;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.MutableAttributes;
import org.jetbrains.annotations.NotNull;

/**
 * Because tables without bootstrap styling looks terrible 🤮
 */
public final class MarkdownTablesBootstrapStylingFixer implements AttributeProvider {

    @Override
    public void setAttributes(
            @NotNull Node node,
            @NotNull AttributablePart attributablePart,
            @NotNull MutableAttributes mutableAttributes) {
        if (node instanceof TableBlock) {
            mutableAttributes.addValue("class", "table table-bordered table-sm");
        }
    }
}