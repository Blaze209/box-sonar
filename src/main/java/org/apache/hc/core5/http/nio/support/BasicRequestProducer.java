package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.net.URI;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.message.BasicHttpRequest;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.RequestChannel;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public class BasicRequestProducer implements AsyncRequestProducer {
    private final AsyncEntityProducer dataProducer;
    private final HttpRequest request;

    public BasicRequestProducer(HttpRequest httpRequest, AsyncEntityProducer asyncEntityProducer) {
        this.request = httpRequest;
        this.dataProducer = asyncEntityProducer;
    }

    public BasicRequestProducer(String str, HttpHost httpHost, String str2, AsyncEntityProducer asyncEntityProducer) {
        this(new BasicHttpRequest(str, httpHost, str2), asyncEntityProducer);
    }

    public BasicRequestProducer(String str, HttpHost httpHost, String str2) {
        this(str, httpHost, str2, (AsyncEntityProducer) null);
    }

    public BasicRequestProducer(String str, URI uri, AsyncEntityProducer asyncEntityProducer) {
        this(new BasicHttpRequest(str, uri), asyncEntityProducer);
    }

    public BasicRequestProducer(String str, URI uri) {
        this(str, uri, (AsyncEntityProducer) null);
    }

    public BasicRequestProducer(Method method, HttpHost httpHost, String str, AsyncEntityProducer asyncEntityProducer) {
        this(new BasicHttpRequest(method, httpHost, str), asyncEntityProducer);
    }

    public BasicRequestProducer(Method method, HttpHost httpHost, String str) {
        this(method, httpHost, str, (AsyncEntityProducer) null);
    }

    public BasicRequestProducer(Method method, URI uri, AsyncEntityProducer asyncEntityProducer) {
        this(new BasicHttpRequest(method, uri), asyncEntityProducer);
    }

    public BasicRequestProducer(Method method, URI uri) {
        this(method, uri, (AsyncEntityProducer) null);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncRequestProducer
    public void sendRequest(RequestChannel requestChannel, HttpContext httpContext) throws HttpException, IOException {
        requestChannel.sendRequest(this.request, this.dataProducer, httpContext);
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

    @Override // org.apache.hc.core5.http.nio.AsyncRequestProducer
    public boolean isRepeatable() {
        AsyncEntityProducer asyncEntityProducer = this.dataProducer;
        return asyncEntityProducer == null || asyncEntityProducer.isRepeatable();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncRequestProducer
    public void failed(Exception exc) {
        try {
            AsyncEntityProducer asyncEntityProducer = this.dataProducer;
            if (asyncEntityProducer != null) {
                asyncEntityProducer.failed(exc);
            }
        } finally {
            releaseResources();
        }
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        AsyncEntityProducer asyncEntityProducer = this.dataProducer;
        if (asyncEntityProducer != null) {
            asyncEntityProducer.releaseResources();
        }
    }
}
