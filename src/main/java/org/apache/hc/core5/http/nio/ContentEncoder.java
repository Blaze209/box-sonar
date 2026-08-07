package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.Header;

/* JADX INFO: loaded from: classes5.dex */
public interface ContentEncoder {
    void complete(List<? extends Header> list) throws IOException;

    boolean isCompleted();

    int write(ByteBuffer byteBuffer) throws IOException;
}
