package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncPushProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicPushProducer implements AsyncPushProducer {
    private final AsyncEntityProducer dataProducer;
    private final HttpResponse response;

    public BasicPushProducer(HttpResponse httpResponse, AsyncEntityProducer asyncEntityProducer) {
        this.response = (HttpResponse) Args.notNull(httpResponse, "Response");
        this.dataProducer = (AsyncEntityProducer) Args.notNull(asyncEntityProducer, "Entity producer");
    }

    public BasicPushProducer(int i, AsyncEntityProducer asyncEntityProducer) {
        this(new BasicHttpResponse(i), asyncEntityProducer);
    }

    public BasicPushProducer(AsyncEntityProducer asyncEntityProducer) {
        this(200, asyncEntityProducer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncPushProducer
    public void produceResponse(ResponseChannel responseChannel, HttpContext httpContext) throws HttpException, IOException {
        responseChannel.sendResponse(this.response, this.dataProducer, httpContext);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        AsyncEntityProducer asyncEntityProducer = this.dataProducer;
        if (asyncEntityProducer != null) {
            return asyncEntityProducer.available();
        }
        return 0;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
        AsyncEntityProducer asyncEntityProducer = this.dataProducer;
        if (asyncEntityProducer != null) {
            asyncEntityProducer.produce(dataStreamChannel);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncPushProducer
    public void failed(Exception exc) {
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        AsyncEntityProducer asyncEntityProducer = this.dataProducer;
        if (asyncEntityProducer != null) {
            asyncEntityProducer.releaseResources();
        }
    }
}
