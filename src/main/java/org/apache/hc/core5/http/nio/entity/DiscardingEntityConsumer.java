package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class DiscardingEntityConsumer<T> implements AsyncEntityConsumer<T> {
    private volatile FutureCallback<T> resultCallback;

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void consume(ByteBuffer byteBuffer) throws IOException {
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public T getContent() {
        return null;
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public void streamStart(EntityDetails entityDetails, FutureCallback<T> futureCallback) throws HttpException, IOException {
        this.resultCallback = futureCallback;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        capacityChannel.update(Integer.MAX_VALUE);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void streamEnd(List<? extends Header> list) throws IOException {
        if (this.resultCallback != null) {
            this.resultCallback.completed(null);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public void failed(Exception exc) {
        if (this.resultCallback != null) {
            this.resultCallback.failed(exc);
        }
    }
}
