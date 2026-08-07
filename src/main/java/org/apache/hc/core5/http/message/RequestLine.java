package org.apache.hc.core5.http.message;

import java.io.Serializable;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class RequestLine implements Serializable {
    private static final long serialVersionUID = 2810581718468737193L;
    private final String method;
    private final ProtocolVersion protoversion;
    private final String uri;

    public RequestLine(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "Request");
        this.method = httpRequest.getMethod();
        this.uri = httpRequest.getRequestUri();
        this.protoversion = httpRequest.getVersion() != null ? httpRequest.getVersion() : HttpVersion.HTTP_1_1;
    }

    public RequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        this.method = (String) Args.notNull(str, "Method");
        this.uri = (String) Args.notNull(str2, "URI");
        this.protoversion = protocolVersion == null ? HttpVersion.HTTP_1_1 : protocolVersion;
    }

    public String getMethod() {
        return this.method;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    public String getUri() {
        return this.uri;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.method).append(" ").append(this.uri).append(" ").append(this.protoversion);
        return sb.toString();
    }
}
