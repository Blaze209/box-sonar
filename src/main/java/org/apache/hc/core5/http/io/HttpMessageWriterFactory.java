package org.apache.hc.core5.http.io;

import org.apache.hc.core5.http.MessageHeaders;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageWriterFactory<T extends MessageHeaders> {
    HttpMessageWriter<T> create();
}
