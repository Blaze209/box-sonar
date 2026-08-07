package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncResponseProducer;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.nio.entity.AsyncEntityProducers;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class ImmediateResponseExchangeHandler implements AsyncServerExchangeHandler {
    private final AsyncResponseProducer responseProducer;

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void consume(ByteBuffer byteBuffer) throws IOException {
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
    }

    public ImmediateResponseExchangeHandler(AsyncResponseProducer asyncResponseProducer) {
        this.responseProducer = (AsyncResponseProducer) Args.notNull(asyncResponseProducer, "Response producer");
    }

    public ImmediateResponseExchangeHandler(HttpResponse httpResponse, String str) {
        this(new BasicResponseProducer(httpResponse, AsyncEntityProducers.create(str)));
    }

    public ImmediateResponseExchangeHandler(int i, String str) {
        this(new BasicHttpResponse(i), str);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncServerExchangeHandler
    public void handleRequest(HttpRequest httpRequest, EntityDetails entityDetails, ResponseChannel responseChannel, HttpContext httpContext) throws HttpException, IOException {
        this.responseProducer.sendResponse(responseChannel, httpContext);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        capacityChannel.update(Integer.MAX_VALUE);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        return this.responseProducer.available();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
        this.responseProducer.produce(dataStreamChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
    public void failed(Exception exc) {
        this.responseProducer.failed(exc);
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.responseProducer.releaseResources();
    }
}
