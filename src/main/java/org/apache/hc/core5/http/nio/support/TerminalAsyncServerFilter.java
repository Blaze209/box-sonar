package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.util.Set;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncFilterChain;
import org.apache.hc.core5.http.nio.AsyncFilterHandler;
import org.apache.hc.core5.http.nio.AsyncPushProducer;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.nio.entity.AsyncEntityProducers;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class TerminalAsyncServerFilter implements AsyncFilterHandler {
    private final HandlerFactory<AsyncServerExchangeHandler> handlerFactory;

    public TerminalAsyncServerFilter(HandlerFactory<AsyncServerExchangeHandler> handlerFactory) {
        this.handlerFactory = (HandlerFactory) Args.notNull(handlerFactory, "Handler factory");
    }

    @Override // org.apache.hc.core5.http.nio.AsyncFilterHandler
    public AsyncDataConsumer handle(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, final AsyncFilterChain.ResponseTrigger responseTrigger, AsyncFilterChain asyncFilterChain) throws HttpException, IOException {
        final AsyncServerExchangeHandler asyncServerExchangeHandler = (AsyncServerExchangeHandler) this.handlerFactory.create(httpRequest, httpContext);
        if (asyncServerExchangeHandler != null) {
            asyncServerExchangeHandler.handleRequest(httpRequest, entityDetails, new ResponseChannel() { // from class: org.apache.hc.core5.http.nio.support.TerminalAsyncServerFilter.1
                @Override // org.apache.hc.core5.http.nio.ResponseChannel
                public void sendInformation(HttpResponse httpResponse, HttpContext httpContext2) throws HttpException, IOException {
                    responseTrigger.sendInformation(httpResponse);
                }

                @Override // org.apache.hc.core5.http.nio.ResponseChannel
                public void sendResponse(HttpResponse httpResponse, final EntityDetails entityDetails2, HttpContext httpContext2) throws HttpException, IOException {
                    responseTrigger.submitResponse(httpResponse, entityDetails2 != null ? new AsyncEntityProducer() { // from class: org.apache.hc.core5.http.nio.support.TerminalAsyncServerFilter.1.1
                        @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
                        public boolean isRepeatable() {
                            return false;
                        }

                        @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
                        public void failed(Exception exc) {
                            asyncServerExchangeHandler.failed(exc);
                        }

                        @Override // org.apache.hc.core5.http.EntityDetails
                        public long getContentLength() {
                            return entityDetails2.getContentLength();
                        }

                        @Override // org.apache.hc.core5.http.EntityDetails
                        public String getContentType() {
                            return entityDetails2.getContentType();
                        }

                        @Override // org.apache.hc.core5.http.EntityDetails
                        public String getContentEncoding() {
                            return entityDetails2.getContentEncoding();
                        }

                        @Override // org.apache.hc.core5.http.EntityDetails
                        public boolean isChunked() {
                            return entityDetails2.isChunked();
                        }

                        @Override // org.apache.hc.core5.http.EntityDetails
                        public Set<String> getTrailerNames() {
                            return entityDetails2.getTrailerNames();
                        }

                        @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
                        public int available() {
                            return asyncServerExchangeHandler.available();
                        }

                        @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
                        public void produce(DataStreamChannel dataStreamChannel) throws IOException {
                            asyncServerExchangeHandler.produce(dataStreamChannel);
                        }

                        @Override // org.apache.hc.core5.http.nio.ResourceHolder
                        public void releaseResources() {
                            asyncServerExchangeHandler.releaseResources();
                        }
                    } : null);
                }

                @Override // org.apache.hc.core5.http.nio.ResponseChannel
                public void pushPromise(HttpRequest httpRequest2, AsyncPushProducer asyncPushProducer, HttpContext httpContext2) throws HttpException, IOException {
                    responseTrigger.pushPromise(httpRequest2, asyncPushProducer);
                }
            }, httpContext);
            return asyncServerExchangeHandler;
        }
        responseTrigger.submitResponse(new BasicHttpResponse(404), AsyncEntityProducers.create("Not found"));
        return null;
    }
}
