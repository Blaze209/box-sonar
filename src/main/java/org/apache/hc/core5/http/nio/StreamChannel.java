package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
public interface StreamChannel<T extends Buffer> {
    void endStream() throws IOException;

    int write(T t) throws IOException;
}
