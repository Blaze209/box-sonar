package org.apache.hc.core5.http.io.support;

import java.util.Arrays;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.support.AbstractResponseBuilder;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ClassicResponseBuilder extends AbstractResponseBuilder<ClassicHttpResponse> {
    private HttpEntity entity;

    ClassicResponseBuilder(int i) {
        super(i);
    }

    public static ClassicResponseBuilder create(int i) {
        Args.checkRange(i, 100, 599, "HTTP status code");
        return new ClassicResponseBuilder(i);
    }

    public static ClassicResponseBuilder copy(ClassicHttpResponse classicHttpResponse) {
        Args.notNull(classicHttpResponse, "HTTP response");
        ClassicResponseBuilder classicResponseBuilder = new ClassicResponseBuilder(classicHttpResponse.getCode());
        classicResponseBuilder.digest(classicHttpResponse);
        return classicResponseBuilder;
    }

    protected void digest(ClassicHttpResponse classicHttpResponse) {
        super.digest((HttpMessage) classicHttpResponse);
        setEntity(classicHttpResponse.getEntity());
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicResponseBuilder setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public ClassicResponseBuilder setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
        return this;
    }

    public ClassicResponseBuilder setEntity(String str, ContentType contentType) {
        this.entity = new StringEntity(str, contentType);
        return this;
    }

    public ClassicResponseBuilder setEntity(String str) {
        this.entity = new StringEntity(str);
        return this;
    }

    public ClassicResponseBuilder setEntity(byte[] bArr, ContentType contentType) {
        this.entity = new ByteArrayEntity(bArr, contentType);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractResponseBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicHttpResponse build() {
        BasicClassicHttpResponse basicClassicHttpResponse = new BasicClassicHttpResponse(getStatus());
        basicClassicHttpResponse.setVersion(getVersion());
        basicClassicHttpResponse.setHeaders(getHeaders());
        basicClassicHttpResponse.setEntity(this.entity);
        return basicClassicHttpResponse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClassicResponseBuilder [status=");
        sb.append(getStatus());
        sb.append(", headerGroup=");
        sb.append(Arrays.toString(getHeaders()));
        sb.append(", entity=");
        HttpEntity httpEntity = this.entity;
        sb.append(httpEntity != null ? httpEntity.getClass() : null);
        sb.append("]");
        return sb.toString();
    }
}
