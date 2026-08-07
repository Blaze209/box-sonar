package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncResponseProducer;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicAsyncServerExpectationDecorator implements AsyncServerExchangeHandler {
    private final Callback<Exception> exceptionCallback;
    private final AsyncServerExchangeHandler handler;
    private final AtomicReference<AsyncResponseProducer> responseProducerRef;

    protected AsyncResponseProducer verify(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        return null;
    }

    public BasicAsyncServerExpectationDecorator(AsyncServerExchangeHandler asyncServerExchangeHandler, Callback<Exception> callback) {
        this.handler = (AsyncServerExchangeHandler) Args.notNull(asyncServerExchangeHandler, "Handler");
        this.exceptionCallback = callback;
        this.responseProducerRef = new AtomicReference<>();
    }

    public BasicAsyncServerExpectationDecorator(AsyncServerExchangeHandler asyncServerExchangeHandler) {
        this(asyncServerExchangeHandler, null);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncServerExchangeHandler
    public final void handleRequest(HttpRequest httpRequest, EntityDetails entityDetails, ResponseChannel responseChannel, HttpContext httpContext) throws HttpException, IOException {
        Header firstHeader;
        if (entityDetails != null && (firstHeader = httpRequest.getFirstHeader("Expect")) != null && "100-continue".equalsIgnoreCase(firstHeader.getValue())) {
            AsyncResponseProducer asyncResponseProducerVerify = verify(httpRequest, httpContext);
            if (asyncResponseProducerVerify != null) {
                this.responseProducerRef.set(asyncResponseProducerVerify);
                asyncResponseProducerVerify.sendResponse(responseChannel, httpContext);
                return;
            }
            responseChannel.sendInformation(new BasicHttpResponse(100), httpContext);
        }
        this.handler.handleRequest(httpRequest, entityDetails, responseChannel, httpContext);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        if (this.responseProducerRef.get() == null) {
            this.handler.updateCapacity(capacityChannel);
        } else {
            capacityChannel.update(Integer.MAX_VALUE);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        if (this.responseProducerRef.get() == null) {
            this.handler.consume(byteBuffer);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        if (this.responseProducerRef.get() == null) {
            this.handler.streamEnd(list);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final int available() {
        AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
        return asyncResponseProducer == null ? this.handler.available() : asyncResponseProducer.available();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(DataStreamChannel dataStreamChannel) throws IOException {
        AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
        if (asyncResponseProducer == null) {
            this.handler.produce(dataStreamChannel);
        } else {
            asyncResponseProducer.produce(dataStreamChannel);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
    public final void failed(Exception exc) {
        Callback<Exception> callback = this.exceptionCallback;
        if (callback != null) {
            callback.execute(exc);
        }
        AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
        if (asyncResponseProducer == null) {
            this.handler.failed(exc);
        } else {
            asyncResponseProducer.failed(exc);
        }
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public final void releaseResources() {
        this.handler.releaseResources();
        AsyncResponseProducer andSet = this.responseProducerRef.getAndSet(null);
        if (andSet != null) {
            andSet.releaseResources();
        }
    }
}
