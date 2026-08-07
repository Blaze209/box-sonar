package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.Header;

/* JADX INFO: loaded from: classes5.dex */
public interface DataStreamChannel extends StreamChannel<ByteBuffer> {
    void endStream(List<? extends Header> list) throws IOException;

    void requestOutput();

    @Override // org.apache.hc.core5.http.nio.StreamChannel
    int write(ByteBuffer byteBuffer) throws IOException;
}
