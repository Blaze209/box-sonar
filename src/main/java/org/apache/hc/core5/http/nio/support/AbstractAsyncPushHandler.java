package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAsyncPushHandler<T> implements AsyncPushConsumer {
    private final AsyncResponseConsumer<T> responseConsumer;

    protected void handleError(HttpRequest httpRequest, Exception exc) {
    }

    protected abstract void handleResponse(HttpRequest httpRequest, T t) throws HttpException, IOException;

    public AbstractAsyncPushHandler(AsyncResponseConsumer<T> asyncResponseConsumer) {
        this.responseConsumer = (AsyncResponseConsumer) Args.notNull(asyncResponseConsumer, "Response consumer");
    }

    @Override // org.apache.hc.core5.http.nio.AsyncPushConsumer
    public final void consumePromise(final HttpRequest httpRequest, HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        this.responseConsumer.consumeResponse(httpResponse, entityDetails, httpContext, new FutureCallback<T>() { // from class: org.apache.hc.core5.http.nio.support.AbstractAsyncPushHandler.1
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(T t) {
                try {
                    AbstractAsyncPushHandler.this.handleResponse(httpRequest, t);
                } catch (Exception e) {
                    failed(e);
                }
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void failed(Exception exc) {
                AbstractAsyncPushHandler.this.handleError(httpRequest, exc);
                AbstractAsyncPushHandler.this.releaseResources();
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void cancelled() {
                AbstractAsyncPushHandler.this.releaseResources();
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.responseConsumer.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        this.responseConsumer.consume(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        this.responseConsumer.streamEnd(list);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncPushConsumer
    public final void failed(Exception exc) {
        this.responseConsumer.failed(exc);
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public final void releaseResources() {
        AsyncResponseConsumer<T> asyncResponseConsumer = this.responseConsumer;
        if (asyncResponseConsumer != null) {
            asyncResponseConsumer.releaseResources();
        }
    }
}
