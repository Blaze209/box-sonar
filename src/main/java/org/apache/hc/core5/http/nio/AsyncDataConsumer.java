package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncDataConsumer extends ResourceHolder {
    void consume(ByteBuffer byteBuffer) throws IOException;

    void streamEnd(List<? extends Header> list) throws HttpException, IOException;

    void updateCapacity(CapacityChannel capacityChannel) throws IOException;
}
