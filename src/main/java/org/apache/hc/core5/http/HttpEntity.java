package org.apache.hc.core5.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.hc.core5.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpEntity extends EntityDetails, Closeable {
    InputStream getContent() throws UnsupportedOperationException, IOException;

    Supplier<List<? extends Header>> getTrailers();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream) throws IOException;
}
