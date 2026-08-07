package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.util.Set;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncEntityProducerWrapper implements AsyncEntityProducer {
    private final AsyncEntityProducer wrappedEntityProducer;

    public AsyncEntityProducerWrapper(AsyncEntityProducer asyncEntityProducer) {
        this.wrappedEntityProducer = (AsyncEntityProducer) Args.notNull(asyncEntityProducer, "Wrapped entity producer");
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public boolean isRepeatable() {
        return this.wrappedEntityProducer.isRepeatable();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.wrappedEntityProducer.isChunked();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.wrappedEntityProducer.getContentLength();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return this.wrappedEntityProducer.getContentType();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return this.wrappedEntityProducer.getContentEncoding();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return this.wrappedEntityProducer.getTrailerNames();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        return this.wrappedEntityProducer.available();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
        this.wrappedEntityProducer.produce(dataStreamChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public void failed(Exception exc) {
        this.wrappedEntityProducer.failed(exc);
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.wrappedEntityProducer.releaseResources();
    }

    public String toString() {
        return "Wrapper [" + this.wrappedEntityProducer + "]";
    }
}
