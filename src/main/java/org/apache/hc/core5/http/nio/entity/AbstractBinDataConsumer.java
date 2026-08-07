package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinDataConsumer implements AsyncDataConsumer {
    private static final ByteBuffer EMPTY = ByteBuffer.wrap(new byte[0]);

    protected abstract int capacityIncrement();

    protected abstract void completed() throws IOException;

    protected abstract void data(ByteBuffer byteBuffer, boolean z) throws IOException;

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        capacityChannel.update(capacityIncrement());
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        data(byteBuffer, false);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        data(EMPTY, true);
        completed();
    }
}
