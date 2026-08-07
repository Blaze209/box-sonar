package org.apache.hc.core5.http.support;

import java.util.Arrays;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicResponseBuilder extends AbstractResponseBuilder<BasicHttpResponse> {
    protected BasicResponseBuilder(int i) {
        super(i);
    }

    public static BasicResponseBuilder create(int i) {
        Args.checkRange(i, 100, 599, "HTTP status code");
        return new BasicResponseBuilder(i);
    }

    public static BasicResponseBuilder copy(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        BasicResponseBuilder basicResponseBuilder = new BasicResponseBuilder(httpResponse.getCode());
        basicResponseBuilder.digest(httpResponse);
        return basicResponseBuilder;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicResponseBuilder setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicHttpResponse build() {
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(getStatus());
        basicHttpResponse.setVersion(getVersion());
        basicHttpResponse.setHeaders(getHeaders());
        return basicHttpResponse;
    }

    public String toString() {
        return "BasicResponseBuilder [status=" + getStatus() + ", headerGroup=" + Arrays.toString(getHeaders()) + "]";
    }
}
