package org.apache.hc.core5.reactor;

import java.nio.channels.SocketChannel;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
final class ChannelEntry {
    final Object attachment;
    final SocketChannel channel;

    public ChannelEntry(SocketChannel socketChannel, Object obj) {
        this.channel = socketChannel;
        this.attachment = obj;
    }

    public String toString() {
        return "[channel=" + this.channel + ", attachment=" + this.attachment + AbstractJsonLexerKt.END_LIST;
    }
}
