package org.commonmark.renderer.text;

import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes5.dex */
public interface TextContentNodeRendererContext {
    TextContentWriter getWriter();

    void render(Node node);

    boolean stripNewlines();
}
