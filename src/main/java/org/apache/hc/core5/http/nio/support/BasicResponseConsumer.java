package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.concurrent.CallbackContribution;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.Message;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicResponseConsumer<T> implements AsyncResponseConsumer<Message<HttpResponse, T>> {
    private final AtomicReference<AsyncEntityConsumer<T>> dataConsumerRef;
    private final Supplier<AsyncEntityConsumer<T>> dataConsumerSupplier;

    static /* synthetic */ AsyncEntityConsumer lambda$new$0(AsyncEntityConsumer asyncEntityConsumer) {
        return asyncEntityConsumer;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncResponseConsumer
    public void informationResponse(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
    }

    public BasicResponseConsumer(Supplier<AsyncEntityConsumer<T>> supplier) {
        this.dataConsumerSupplier = (Supplier) Args.notNull(supplier, "Data consumer supplier");
        this.dataConsumerRef = new AtomicReference<>();
    }

    public BasicResponseConsumer(final AsyncEntityConsumer<T> asyncEntityConsumer) {
        this(new Supplier() { // from class: org.apache.hc.core5.http.nio.support.BasicResponseConsumer$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return BasicResponseConsumer.lambda$new$0(asyncEntityConsumer);
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncResponseConsumer
    public void consumeResponse(final HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext, final FutureCallback<Message<HttpResponse, T>> futureCallback) throws HttpException, IOException {
        Args.notNull(httpResponse, "Response");
        if (entityDetails == null) {
            if (futureCallback != null) {
                futureCallback.completed(new Message<>(httpResponse));
            }
        } else {
            AsyncEntityConsumer<T> asyncEntityConsumer = this.dataConsumerSupplier.get();
            if (asyncEntityConsumer == null) {
                throw new HttpException("Supplied data consumer is null");
            }
            this.dataConsumerRef.set(asyncEntityConsumer);
            asyncEntityConsumer.streamStart(entityDetails, new CallbackContribution<T>(futureCallback) { // from class: org.apache.hc.core5.http.nio.support.BasicResponseConsumer.1
                @Override // org.apache.hc.core5.concurrent.FutureCallback
                public void completed(T t) {
                    FutureCallback futureCallback2 = futureCallback;
                    if (futureCallback2 != null) {
                        futureCallback2.completed(new Message(httpResponse, t));
                    }
                }
            });
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.dataConsumerRef.get().updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void consume(ByteBuffer byteBuffer) throws IOException {
        this.dataConsumerRef.get().consume(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        this.dataConsumerRef.get().streamEnd(list);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncResponseConsumer
    public void failed(Exception exc) {
        AsyncEntityConsumer<T> asyncEntityConsumer = this.dataConsumerRef.get();
        if (asyncEntityConsumer != null) {
            asyncEntityConsumer.failed(exc);
        }
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        AsyncEntityConsumer<T> andSet = this.dataConsumerRef.getAndSet(null);
        if (andSet != null) {
            andSet.releaseResources();
        }
    }
}
