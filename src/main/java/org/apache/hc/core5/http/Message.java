package org.apache.hc.core5.http;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.MessageHeaders;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class Message<H extends MessageHeaders, B> {
    private final B body;
    private final H head;

    public Message(H h) {
        this(h, null);
    }

    public Message(H h, B b) {
        this.head = (H) Args.notNull(h, "Message head");
        this.body = b;
    }

    public H getHead() {
        return this.head;
    }

    public B getBody() {
        return this.body;
    }

    public String toString() {
        return "[head=" + this.head + ", body=" + this.body + AbstractJsonLexerKt.END_LIST;
    }
}
