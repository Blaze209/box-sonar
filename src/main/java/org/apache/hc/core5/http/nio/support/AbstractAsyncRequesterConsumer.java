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
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.http.nio.AsyncRequestConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAsyncRequesterConsumer<T, E> implements AsyncRequestConsumer<T> {
    private final AtomicReference<AsyncEntityConsumer<E>> dataConsumerRef;
    private final Supplier<AsyncEntityConsumer<E>> dataConsumerSupplier;

    static /* synthetic */ AsyncEntityConsumer lambda$new$0(AsyncEntityConsumer asyncEntityConsumer) {
        return asyncEntityConsumer;
    }

    protected abstract T buildResult(HttpRequest httpRequest, E e, ContentType contentType);

    public AbstractAsyncRequesterConsumer(Supplier<AsyncEntityConsumer<E>> supplier) {
        this.dataConsumerSupplier = (Supplier) Args.notNull(supplier, "Data consumer supplier");
        this.dataConsumerRef = new AtomicReference<>();
    }

    public AbstractAsyncRequesterConsumer(final AsyncEntityConsumer<E> asyncEntityConsumer) {
        this(new Supplier() { // from class: org.apache.hc.core5.http.nio.support.AbstractAsyncRequesterConsumer$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return AbstractAsyncRequesterConsumer.lambda$new$0(asyncEntityConsumer);
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncRequestConsumer
    public final void consumeRequest(final HttpRequest httpRequest, final EntityDetails entityDetails, HttpContext httpContext, final FutureCallback<T> futureCallback) throws HttpException, IOException {
        if (entityDetails != null) {
            AsyncEntityConsumer<E> asyncEntityConsumer = this.dataConsumerSupplier.get();
            if (asyncEntityConsumer == null) {
                throw new HttpException("Supplied data consumer is null");
            }
            this.dataConsumerRef.set(asyncEntityConsumer);
            asyncEntityConsumer.streamStart(entityDetails, new CallbackContribution<E>(futureCallback) { // from class: org.apache.hc.core5.http.nio.support.AbstractAsyncRequesterConsumer.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // org.apache.hc.core5.concurrent.FutureCallback
                public void completed(E e) {
                    try {
                        futureCallback.completed(AbstractAsyncRequesterConsumer.this.buildResult(httpRequest, e, ContentType.parse(entityDetails.getContentType())));
                    } catch (UnsupportedCharsetException e2) {
                        futureCallback.failed(e2);
                    }
                }
            });
            return;
        }
        futureCallback.completed(buildResult(httpRequest, null, null));
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.dataConsumerRef.get().updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        this.dataConsumerRef.get().consume(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        this.dataConsumerRef.get().streamEnd(list);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncRequestConsumer
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
