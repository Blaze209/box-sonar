package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.concurrent.CallbackContribution;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAsyncResponseConsumer<T, E> implements AsyncResponseConsumer<T> {
    private final AtomicReference<AsyncEntityConsumer<E>> dataConsumerRef;
    private final Supplier<AsyncEntityConsumer<E>> dataConsumerSupplier;

    static /* synthetic */ AsyncEntityConsumer lambda$new$0(AsyncEntityConsumer asyncEntityConsumer) {
        return asyncEntityConsumer;
    }

    protected abstract T buildResult(HttpResponse httpResponse, E e, ContentType contentType);

    public AbstractAsyncResponseConsumer(Supplier<AsyncEntityConsumer<E>> supplier) {
        this.dataConsumerSupplier = (Supplier) Args.notNull(supplier, "Data consumer supplier");
        this.dataConsumerRef = new AtomicReference<>();
    }

    public AbstractAsyncResponseConsumer(final AsyncEntityConsumer<E> asyncEntityConsumer) {
        this(new Supplier() { // from class: org.apache.hc.core5.http.nio.support.AbstractAsyncResponseConsumer$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return AbstractAsyncResponseConsumer.lambda$new$0(asyncEntityConsumer);
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncResponseConsumer
    public final void consumeResponse(final HttpResponse httpResponse, final EntityDetails entityDetails, HttpContext httpContext, final FutureCallback<T> futureCallback) throws HttpException, IOException {
        if (entityDetails != null) {
            AsyncEntityConsumer<E> asyncEntityConsumer = this.dataConsumerSupplier.get();
            if (asyncEntityConsumer == null) {
                throw new HttpException("Supplied data consumer is null");
            }
            this.dataConsumerRef.set(asyncEntityConsumer);
            asyncEntityConsumer.streamStart(entityDetails, new CallbackContribution<E>(futureCallback) { // from class: org.apache.hc.core5.http.nio.support.AbstractAsyncResponseConsumer.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // org.apache.hc.core5.concurrent.FutureCallback
                public void completed(E e) {
                    try {
                        Object objBuildResult = AbstractAsyncResponseConsumer.this.buildResult(httpResponse, e, ContentType.parse(entityDetails.getContentType()));
                        FutureCallback futureCallback2 = futureCallback;
                        if (futureCallback2 != 0) {
                            futureCallback2.completed(objBuildResult);
                        }
                    } catch (UnsupportedCharsetException e2) {
                        FutureCallback futureCallback3 = futureCallback;
                        if (futureCallback3 != null) {
                            futureCallback3.failed(e2);
                        }
                    }
                }
            });
            return;
        }
        T tBuildResult = buildResult(httpResponse, null, null);
        if (futureCallback != null) {
            futureCallback.completed(tBuildResult);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        AsyncEntityConsumer<E> asyncEntityConsumer = this.dataConsumerRef.get();
        if (asyncEntityConsumer != null) {
            asyncEntityConsumer.updateCapacity(capacityChannel);
        } else {
            capacityChannel.update(Integer.MAX_VALUE);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        AsyncEntityConsumer<E> asyncEntityConsumer = this.dataConsumerRef.get();
        if (asyncEntityConsumer != null) {
            asyncEntityConsumer.consume(byteBuffer);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        AsyncEntityConsumer<E> asyncEntityConsumer = this.dataConsumerRef.get();
        if (asyncEntityConsumer != null) {
            asyncEntityConsumer.streamEnd(list);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncResponseConsumer
    public final void failed(Exception exc) {
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public final void releaseResources() {
        AsyncEntityConsumer<E> andSet = this.dataConsumerRef.getAndSet(null);
        if (andSet != null) {
            andSet.releaseResources();
        }
    }
}
