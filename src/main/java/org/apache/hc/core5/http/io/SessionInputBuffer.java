package org.apache.hc.core5.http.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionInputBuffer {
    int available();

    int capacity();

    HttpTransportMetrics getMetrics();

    int length();

    int read(InputStream inputStream) throws IOException;

    int read(byte[] bArr, int i, int i2, InputStream inputStream) throws IOException;

    int read(byte[] bArr, InputStream inputStream) throws IOException;

    int readLine(CharArrayBuffer charArrayBuffer, InputStream inputStream) throws IOException;
}
