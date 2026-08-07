package org.commonmark.ext.gfm.strikethrough;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughDelimiterProcessor;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughHtmlNodeRenderer;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughTextContentNodeRenderer;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentNodeRendererContext;
import org.commonmark.renderer.text.TextContentNodeRendererFactory;
import org.commonmark.renderer.text.TextContentRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class StrikethroughExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, TextContentRenderer.TextContentRendererExtension {
    private StrikethroughExtension() {
    }

    public static Extension create() {
        return new StrikethroughExtension();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder builder) {
        builder.customDelimiterProcessor(new StrikethroughDelimiterProcessor());
    }

    @Override // org.commonmark.renderer.html.HtmlRenderer.HtmlRendererExtension
    public void extend(HtmlRenderer.Builder builder) {
        builder.nodeRendererFactory(new HtmlNodeRendererFactory() { // from class: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension.1
            @Override // org.commonmark.renderer.html.HtmlNodeRendererFactory
            public NodeRenderer create(HtmlNodeRendererContext htmlNodeRendererContext) {
                return new StrikethroughHtmlNodeRenderer(htmlNodeRendererContext);
            }
        });
    }

    @Override // org.commonmark.renderer.text.TextContentRenderer.TextContentRendererExtension
    public void extend(TextContentRenderer.Builder builder) {
        builder.nodeRendererFactory(new TextContentNodeRendererFactory() { // from class: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension.2
            @Override // org.commonmark.renderer.text.TextContentNodeRendererFactory
            public NodeRenderer create(TextContentNodeRendererContext textContentNodeRendererContext) {
                return new StrikethroughTextContentNodeRenderer(textContentNodeRendererContext);
            }
        });
    }
}
