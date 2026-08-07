package org.apache.hc.core5.http.support;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ProtocolVersion;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractResponseBuilder<T> extends AbstractMessageBuilder<T> {
    private int status;

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    protected abstract T build();

    protected AbstractResponseBuilder(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractResponseBuilder<T> setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }
}
