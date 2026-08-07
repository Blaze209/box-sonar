package org.apache.hc.core5.http.nio;

import org.apache.hc.core5.http.MessageHeaders;

/* JADX INFO: loaded from: classes5.dex */
public interface NHttpMessageParserFactory<T extends MessageHeaders> {
    NHttpMessageParser<T> create();
}
