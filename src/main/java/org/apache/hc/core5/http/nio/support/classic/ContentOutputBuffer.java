package org.apache.hc.core5.http.nio.support.classic;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface ContentOutputBuffer {
    int length();

    void reset();

    void write(int i) throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;

    void writeCompleted() throws IOException;
}
