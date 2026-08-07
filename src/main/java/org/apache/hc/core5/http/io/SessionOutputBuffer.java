package org.apache.hc.core5.http.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionOutputBuffer {
    int available();

    int capacity();

    void flush(OutputStream outputStream) throws IOException;

    HttpTransportMetrics getMetrics();

    int length();

    void write(int i, OutputStream outputStream) throws IOException;

    void write(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException;

    void write(byte[] bArr, OutputStream outputStream) throws IOException;

    void writeLine(CharArrayBuffer charArrayBuffer, OutputStream outputStream) throws IOException;
}
