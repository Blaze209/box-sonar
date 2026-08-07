package org.apache.hc.core5.http.nio.support.classic;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface ContentInputBuffer {
    int length();

    int read() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    void reset();
}
