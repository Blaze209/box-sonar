package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessage extends MessageHeaders {
    void addHeader(String str, Object obj);

    void addHeader(Header header);

    ProtocolVersion getVersion();

    boolean removeHeader(Header header);

    boolean removeHeaders(String str);

    void setHeader(String str, Object obj);

    void setHeader(Header header);

    void setHeaders(Header... headerArr);

    void setVersion(ProtocolVersion protocolVersion);
}
