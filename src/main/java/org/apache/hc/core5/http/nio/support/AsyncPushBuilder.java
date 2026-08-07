package org.apache.hc.core5.http.nio.support;

import java.util.Arrays;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncPushProducer;
import org.apache.hc.core5.http.nio.entity.BasicAsyncEntityProducer;
import org.apache.hc.core5.http.support.AbstractResponseBuilder;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncPushBuilder extends AbstractResponseBuilder<AsyncPushProducer> {
    private AsyncEntityProducer entityProducer;

    AsyncPushBuilder(int i) {
        super(i);
    }

    public static AsyncPushBuilder create(int i) {
        Args.checkRange(i, 100, 599, "HTTP status code");
        return new AsyncPushBuilder(i);
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushBuilder setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    public AsyncEntityProducer getEntity() {
        return this.entityProducer;
    }

    public AsyncPushBuilder setEntity(AsyncEntityProducer asyncEntityProducer) {
        this.entityProducer = asyncEntityProducer;
        return this;
    }

    public AsyncPushBuilder setEntity(String str, ContentType contentType) {
        this.entityProducer = new BasicAsyncEntityProducer(str, contentType);
        return this;
    }

    public AsyncPushBuilder setEntity(String str) {
        this.entityProducer = new BasicAsyncEntityProducer(str);
        return this;
    }

    public AsyncPushBuilder setEntity(byte[] bArr, ContentType contentType) {
        this.entityProducer = new BasicAsyncEntityProducer(bArr, contentType);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncPushProducer build() {
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(getStatus());
        basicHttpResponse.setVersion(getVersion());
        basicHttpResponse.setHeaders(getHeaders());
        return new BasicPushProducer(basicHttpResponse, this.entityProducer);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AsyncPushProducer [status=");
        sb.append(getStatus());
        sb.append(", headerGroup=");
        sb.append(Arrays.toString(getHeaders()));
        sb.append(", entity=");
        AsyncEntityProducer asyncEntityProducer = this.entityProducer;
        sb.append(asyncEntityProducer != null ? asyncEntityProducer.getClass() : null);
        sb.append("]");
        return sb.toString();
    }
}
