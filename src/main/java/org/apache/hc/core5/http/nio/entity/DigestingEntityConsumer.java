package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DigestingEntityConsumer<T> implements AsyncEntityConsumer<T> {
    private volatile byte[] digest;
    private final MessageDigest digester;
    private final List<Header> trailers = new ArrayList();
    private final AsyncEntityConsumer<T> wrapped;

    public DigestingEntityConsumer(String str, AsyncEntityConsumer<T> asyncEntityConsumer) throws NoSuchAlgorithmException {
        this.wrapped = (AsyncEntityConsumer) Args.notNull(asyncEntityConsumer, "Entity consumer");
        this.digester = MessageDigest.getInstance(str);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public void streamStart(EntityDetails entityDetails, FutureCallback<T> futureCallback) throws HttpException, IOException {
        this.wrapped.streamStart(entityDetails, futureCallback);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.wrapped.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void consume(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.mark();
        this.digester.update(byteBuffer);
        byteBuffer.reset();
        this.wrapped.consume(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        if (list != null) {
            this.trailers.addAll(list);
        }
        this.digest = this.digester.digest();
        this.wrapped.streamEnd(list);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public void failed(Exception exc) {
        this.wrapped.failed(exc);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public T getContent() {
        return this.wrapped.getContent();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.wrapped.releaseResources();
    }

    public List<Header> getTrailers() {
        if (this.trailers != null) {
            return new ArrayList(this.trailers);
        }
        return null;
    }

    public byte[] getDigest() {
        return this.digest;
    }
}
