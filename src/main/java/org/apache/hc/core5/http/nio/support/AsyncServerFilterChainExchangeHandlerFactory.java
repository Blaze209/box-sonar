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
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncFilterChain;
import org.apache.hc.core5.http.nio.AsyncPushProducer;
import org.apache.hc.core5.http.nio.AsyncResponseProducer;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncServerFilterChainExchangeHandlerFactory implements HandlerFactory<AsyncServerExchangeHandler> {
    private final Callback<Exception> exceptionCallback;
    private final AsyncServerFilterChainElement filterChain;

    public AsyncServerFilterChainExchangeHandlerFactory(AsyncServerFilterChainElement asyncServerFilterChainElement, Callback<Exception> callback) {
        this.filterChain = (AsyncServerFilterChainElement) Args.notNull(asyncServerFilterChainElement, "Filter chain");
        this.exceptionCallback = callback;
    }

    public AsyncServerFilterChainExchangeHandlerFactory(AsyncServerFilterChainElement asyncServerFilterChainElement) {
        this(asyncServerFilterChainElement, null);
    }

    @Override // org.apache.hc.core5.http.nio.HandlerFactory
    public AsyncServerExchangeHandler create(HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        return new AsyncServerExchangeHandler() { // from class: org.apache.hc.core5.http.nio.support.AsyncServerFilterChainExchangeHandlerFactory.1
            private final AtomicReference<AsyncDataConsumer> dataConsumerRef = new AtomicReference<>();
            private final AtomicReference<AsyncResponseProducer> responseProducerRef = new AtomicReference<>();

            @Override // org.apache.hc.core5.http.nio.AsyncServerExchangeHandler
            public void handleRequest(HttpRequest httpRequest2, EntityDetails entityDetails, final ResponseChannel responseChannel, final HttpContext httpContext2) throws HttpException, IOException {
                this.dataConsumerRef.set(AsyncServerFilterChainExchangeHandlerFactory.this.filterChain.handle(httpRequest2, entityDetails, httpContext2, new AsyncFilterChain.ResponseTrigger() { // from class: org.apache.hc.core5.http.nio.support.AsyncServerFilterChainExchangeHandlerFactory.1.1
                    @Override // org.apache.hc.core5.http.nio.AsyncFilterChain.ResponseTrigger
                    public void sendInformation(HttpResponse httpResponse) throws HttpException, IOException {
                        responseChannel.sendInformation(httpResponse, httpContext2);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncFilterChain.ResponseTrigger
                    public void submitResponse(HttpResponse httpResponse, AsyncEntityProducer asyncEntityProducer) throws HttpException, IOException {
                        BasicResponseProducer basicResponseProducer = new BasicResponseProducer(httpResponse, asyncEntityProducer);
                        AnonymousClass1.this.responseProducerRef.set(basicResponseProducer);
                        basicResponseProducer.sendResponse(responseChannel, httpContext2);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncFilterChain.ResponseTrigger
                    public void pushPromise(HttpRequest httpRequest3, AsyncPushProducer asyncPushProducer) throws HttpException, IOException {
                        responseChannel.pushPromise(httpRequest3, asyncPushProducer, httpContext2);
                    }
                }));
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
            public void failed(Exception exc) {
                if (AsyncServerFilterChainExchangeHandlerFactory.this.exceptionCallback != null) {
                    AsyncServerFilterChainExchangeHandlerFactory.this.exceptionCallback.execute(exc);
                }
                AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
                if (asyncResponseProducer != null) {
                    asyncResponseProducer.failed(exc);
                }
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
            public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
                AsyncDataConsumer asyncDataConsumer = this.dataConsumerRef.get();
                if (asyncDataConsumer != null) {
                    asyncDataConsumer.updateCapacity(capacityChannel);
                } else {
                    capacityChannel.update(Integer.MAX_VALUE);
                }
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
            public void consume(ByteBuffer byteBuffer) throws IOException {
                AsyncDataConsumer asyncDataConsumer = this.dataConsumerRef.get();
                if (asyncDataConsumer != null) {
                    asyncDataConsumer.consume(byteBuffer);
                }
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
            public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
                AsyncDataConsumer asyncDataConsumer = this.dataConsumerRef.get();
                if (asyncDataConsumer != null) {
                    asyncDataConsumer.streamEnd(list);
                }
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
            public int available() {
                AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
                Asserts.notNull(asyncResponseProducer, "Response producer");
                return asyncResponseProducer.available();
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
            public void produce(DataStreamChannel dataStreamChannel) throws IOException {
                AsyncResponseProducer asyncResponseProducer = this.responseProducerRef.get();
                Asserts.notNull(asyncResponseProducer, "Response producer");
                asyncResponseProducer.produce(dataStreamChannel);
            }

            @Override // org.apache.hc.core5.http.nio.ResourceHolder
            public void releaseResources() {
                AsyncDataConsumer andSet = this.dataConsumerRef.getAndSet(null);
                if (andSet != null) {
                    andSet.releaseResources();
                }
                AsyncResponseProducer andSet2 = this.responseProducerRef.getAndSet(null);
                if (andSet2 != null) {
                    andSet2.releaseResources();
                }
            }
        };
    }
}
