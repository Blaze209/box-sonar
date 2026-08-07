package org.apache.hc.core5.http.nio.support;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.nio.AsyncPushProducer;
import org.apache.hc.core5.http.nio.AsyncRequestConsumer;
import org.apache.hc.core5.http.nio.AsyncResponseProducer;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.AsyncServerRequestHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractServerExchangeHandler<T> implements AsyncServerExchangeHandler {
    private final AtomicReference<AsyncRequestConsumer<T>> requestConsumerRef = new AtomicReference<>();
    private final AtomicReference<AsyncResponseProducer> responseProducerRef = new AtomicReference<>();

    protected abstract void handle(T t, AsyncServerRequestHandler.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException;

    protected abstract AsyncRequestConsumer<T> supplyConsumer(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException;

    @Override // org.apache.hc.core5.http.nio.AsyncServerExchangeHandler
    public final void handleRequest(HttpRequest httpRequest, EntityDetails entityDetails, final ResponseChannel responseChannel, final HttpContext httpContext) throws HttpException, IOException {
        AsyncRequestConsumer<T> asyncRequestConsumerSupplyConsumer = supplyConsumer(httpRequest, entityDetails, httpContext);
        if (asyncRequestConsumerSupplyConsumer == null) {
            throw new HttpException("Unable to handle request");
        }
        this.requestConsumerRef.set(asyncRequestConsumerSupplyConsumer);
        final AsyncServerRequestHandler.ResponseTrigger responseTrigger = new AsyncServerRequestHandler.ResponseTrigger() { // from class: org.apache.hc.core5.http.nio.support.AbstractServerExchangeHandler.1
            @Override // org.apache.hc.core5.http.nio.AsyncServerRequestHandler.ResponseTrigger
            public void sendInformation(HttpResponse httpResponse, HttpContext httpContext2) throws HttpException, IOException {
                responseChannel.sendInformation(httpResponse, httpContext2);
            }

            @Override // org.apache.hc.core5.http.nio.AsyncServerRequestHandler.ResponseTrigger
            public void submitResponse(AsyncResponseProducer asyncResponseProducer, HttpContext httpContext2) throws HttpException, IOException {
                if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(AbstractServerExchangeHandler.this.responseProducerRef, null, asyncResponseProducer)) {
                    asyncResponseProducer.sendResponse(responseChannel, httpContext2);
                }
            }

            @Override // org.apache.hc.core5.http.nio.AsyncServerRequestHandler.ResponseTrigger
            public void pushPromise(HttpRequest httpRequest2, HttpContext httpContext2, AsyncPushProducer asyncPushProducer) throws HttpException, IOException {
                responseChannel.pushPromise(httpRequest2, asyncPushProducer, httpContext2);
            }

            public String toString() {
                return "Response trigger: " + responseChannel;
            }
        };
        asyncRequestConsumerSupplyConsumer.consumeRequest(httpRequest, entityDetails, httpContext, new FutureCallback<T>() { // from class: org.apache.hc.core5.http.nio.support.AbstractServerExchangeHandler.2
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(T t) {
                try {
                    AbstractServerExchangeHandler.this.handle(t, responseTrigger, httpContext);
                } catch (IOException e) {
                    failed(e);
                } catch (HttpException e2) {
                    try {
                        responseTrigger.submitResponse(AsyncResponseBuilder.create(500).setEntity(e2.getMessage()).build(), httpContext);
                    } catch (IOException | HttpException e3) {
                        failed(e3);
                    }
                }
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void failed(Exception exc) {
                AbstractServerExchangeHandler.this.failed(exc);
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void cancelled() {
                AbstractServerExchangeHandler.this.releaseResources();
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        AsyncRequestConsumer<T> asyncRequestConsumer = this.requestConsumerRef.get();
        Asserts.notNull(asyncRequestConsumer, "Data consumer");
        asyncRequestConsumer.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        AsyncRequestConsumer<T> asyncRequestConsumer = this.requestConsumerRef.get();
        Asserts.notNull(asyncRequestConsumer, "Data consumer");
        asyncRequestConsumer.consume(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        AsyncRequestConsumer<T> asyncRequestConsumer = this.requestConsumerRef.get();
        Asserts.notNull(asyncRequestConsumer, "Data consumer");
        asyncRequestConsumer.streamEnd(list);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final int available() {
        AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
        if (asyncResponseProducer != null) {
            return asyncResponseProducer.available();
        }
        return 0;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(DataStreamChannel dataStreamChannel) throws IOException {
        AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
        Asserts.notNull(asyncResponseProducer, "Data producer");
        asyncResponseProducer.produce(dataStreamChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
    public final void failed(Exception exc) {
        try {
            AsyncRequestConsumer<T> asyncRequestConsumer = this.requestConsumerRef.get();
            if (asyncRequestConsumer != null) {
                asyncRequestConsumer.failed(exc);
            }
            AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
            if (asyncResponseProducer != null) {
                asyncResponseProducer.failed(exc);
            }
        } finally {
            releaseResources();
        }
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public final void releaseResources() {
        AsyncRequestConsumer<T> andSet = this.requestConsumerRef.getAndSet(null);
        if (andSet != null) {
            andSet.releaseResources();
        }
        AsyncResponseProducer andSet2 = this.responseProducerRef.getAndSet(null);
        if (andSet2 != null) {
            andSet2.releaseResources();
        }
    }
}
