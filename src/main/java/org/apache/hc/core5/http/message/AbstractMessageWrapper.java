package org.apache.hc.core5.http.message;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.Iterator;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageWrapper<T extends HttpMessage> implements HttpMessage {
    private final T message;

    public AbstractMessageWrapper(T t) {
        this.message = (T) Args.notNull(t, AuthenticationConstants.BUNDLE_MESSAGE);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setVersion(ProtocolVersion protocolVersion) {
        this.message.setVersion(protocolVersion);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public ProtocolVersion getVersion() {
        return this.message.getVersion();
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void addHeader(Header header) {
        this.message.addHeader(header);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void addHeader(String str, Object obj) {
        this.message.addHeader(str, obj);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setHeader(Header header) {
        this.message.setHeader(header);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setHeader(String str, Object obj) {
        this.message.setHeader(str, obj);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setHeaders(Header... headerArr) {
        this.message.setHeaders(headerArr);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public boolean removeHeader(Header header) {
        return this.message.removeHeader(header);
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public boolean removeHeaders(String str) {
        return this.message.removeHeaders(str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public boolean containsHeader(String str) {
        return this.message.containsHeader(str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public int countHeaders(String str) {
        return this.message.countHeaders(str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header[] getHeaders(String str) {
        return this.message.getHeaders(str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header getHeader(String str) throws ProtocolException {
        return this.message.getHeader(str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header getFirstHeader(String str) {
        return this.message.getFirstHeader(str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header getLastHeader(String str) {
        return this.message.getLastHeader(str);
    }

    T getMessage() {
        return this.message;
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header[] getHeaders() {
        return this.message.getHeaders();
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Iterator<Header> headerIterator() {
        return this.message.headerIterator();
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Iterator<Header> headerIterator(String str) {
        return this.message.headerIterator(str);
    }

    public String toString() {
        return this.message.toString();
    }
}
