package org.tinylog.writers.raw;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface ByteArrayWriter {
    void close() throws IOException;

    void flush() throws IOException;

    int readTail(byte[] bArr, int i, int i2) throws IOException;

    void truncate(int i) throws IOException;

    @Deprecated
    void write(byte[] bArr, int i) throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
