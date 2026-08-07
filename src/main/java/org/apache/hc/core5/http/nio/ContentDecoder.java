package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.Header;

/* JADX INFO: loaded from: classes5.dex */
public interface ContentDecoder {
    List<? extends Header> getTrailers();

    boolean isCompleted();

    int read(ByteBuffer byteBuffer) throws IOException;
}
