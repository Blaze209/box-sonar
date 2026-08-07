package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.nio.AsyncClientExchangeHandler;
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.RequestChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class BasicClientExchangeHandler<T> implements AsyncClientExchangeHandler {
    private final AtomicBoolean completed = new AtomicBoolean();
    private final AtomicBoolean outputTerminated = new AtomicBoolean();
    private final AsyncRequestProducer requestProducer;
    private final AsyncResponseConsumer<T> responseConsumer;
    private final FutureCallback<T> resultCallback;

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
    }

    public BasicClientExchangeHandler(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, FutureCallback<T> futureCallback) {
        this.requestProducer = (AsyncRequestProducer) Args.notNull(asyncRequestProducer, "Request producer");
        this.responseConsumer = (AsyncResponseConsumer) Args.notNull(asyncResponseConsumer, "Response consumer");
        this.resultCallback = futureCallback;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
    public void produceRequest(RequestChannel requestChannel, HttpContext httpContext) throws HttpException, IOException {
        this.requestProducer.sendRequest(requestChannel, httpContext);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        return this.requestProducer.available();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
        if (this.outputTerminated.get()) {
            dataStreamChannel.endStream();
        } else {
            this.requestProducer.produce(dataStreamChannel);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
    public void consumeInformation(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        this.responseConsumer.informationResponse(httpResponse, httpContext);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
    public void consumeResponse(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        if (httpResponse.getCode() >= 400) {
            this.outputTerminated.set(true);
            this.requestProducer.releaseResources();
        }
        this.responseConsumer.consumeResponse(httpResponse, entityDetails, httpContext, new FutureCallback<T>() { // from class: org.apache.hc.core5.http.nio.support.BasicClientExchangeHandler.1
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(T t) {
                if (BasicClientExchangeHandler.this.completed.compareAndSet(false, true)) {
                    try {
                        if (BasicClientExchangeHandler.this.resultCallback != null) {
                            BasicClientExchangeHandler.this.resultCallback.completed(t);
                        }
                    } finally {
                        BasicClientExchangeHandler.this.internalReleaseResources();
                    }
                }
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void failed(Exception exc) {
                if (BasicClientExchangeHandler.this.completed.compareAndSet(false, true)) {
                    try {
                        if (BasicClientExchangeHandler.this.resultCallback != null) {
                            BasicClientExchangeHandler.this.resultCallback.failed(exc);
                        }
                    } finally {
                        BasicClientExchangeHandler.this.internalReleaseResources();
                    }
                }
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void cancelled() {
                if (BasicClientExchangeHandler.this.completed.compareAndSet(false, true)) {
                    try {
                        if (BasicClientExchangeHandler.this.resultCallback != null) {
                            BasicClientExchangeHandler.this.resultCallback.cancelled();
                        }
                    } finally {
                        BasicClientExchangeHandler.this.internalReleaseResources();
                    }
                }
            }
        });
    }

    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
    public void cancel() {
        if (this.completed.compareAndSet(false, true)) {
            try {
                FutureCallback<T> futureCallback = this.resultCallback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
            } finally {
                internalReleaseResources();
            }
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.responseConsumer.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void consume(ByteBuffer byteBuffer) throws IOException {
        this.responseConsumer.consume(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        this.responseConsumer.streamEnd(list);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
    public void failed(Exception exc) {
        try {
            this.requestProducer.failed(exc);
            this.responseConsumer.failed(exc);
            if (this.completed.compareAndSet(false, true)) {
                try {
                    FutureCallback<T> futureCallback = this.resultCallback;
                    if (futureCallback != null) {
                        futureCallback.failed(exc);
                    }
                } finally {
                    internalReleaseResources();
                }
            }
        } catch (Throwable th) {
            if (this.completed.compareAndSet(false, true)) {
                try {
                    FutureCallback<T> futureCallback2 = this.resultCallback;
                    if (futureCallback2 != null) {
                        futureCallback2.failed(exc);
                    }
                } finally {
                    internalReleaseResources();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalReleaseResources() {
        this.requestProducer.releaseResources();
        this.responseConsumer.releaseResources();
    }
}
