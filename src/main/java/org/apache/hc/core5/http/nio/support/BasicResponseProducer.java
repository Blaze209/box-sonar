package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncResponseProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.nio.entity.AsyncEntityProducers;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicResponseProducer implements AsyncResponseProducer {
    private final AsyncEntityProducer dataProducer;
    private final HttpResponse response;

    public BasicResponseProducer(HttpResponse httpResponse, AsyncEntityProducer asyncEntityProducer) {
        this.response = (HttpResponse) Args.notNull(httpResponse, "Response");
        this.dataProducer = asyncEntityProducer;
    }

    public BasicResponseProducer(HttpResponse httpResponse) {
        this.response = (HttpResponse) Args.notNull(httpResponse, "Response");
        this.dataProducer = null;
    }

    public BasicResponseProducer(int i, AsyncEntityProducer asyncEntityProducer) {
        this(new BasicHttpResponse(i), asyncEntityProducer);
    }

    public BasicResponseProducer(HttpResponse httpResponse, String str, ContentType contentType) {
        this(httpResponse, AsyncEntityProducers.create(str, contentType));
    }

    public BasicResponseProducer(HttpResponse httpResponse, String str) {
        this(httpResponse, str, ContentType.TEXT_PLAIN);
    }

    public BasicResponseProducer(int i, String str, ContentType contentType) {
        this(new BasicHttpResponse(i), str, contentType);
    }

    public BasicResponseProducer(int i, String str) {
        this(new BasicHttpResponse(i), str);
    }

    public BasicResponseProducer(AsyncEntityProducer asyncEntityProducer) {
        this(200, asyncEntityProducer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncResponseProducer
    public void sendResponse(ResponseChannel responseChannel, HttpContext httpContext) throws HttpException, IOException {
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

    @Override // org.apache.hc.core5.http.nio.AsyncResponseProducer
    public void failed(Exception exc) {
        AsyncEntityProducer asyncEntityProducer = this.dataProducer;
        if (asyncEntityProducer != null) {
            asyncEntityProducer.failed(exc);
        }
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
