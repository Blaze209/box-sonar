package org.apache.hc.core5.http.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;
    private ProtocolVersion version;

    public BasicHttpContext() {
        this(null);
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public Object getAttribute(String str) {
        HttpContext httpContext;
        Args.notNull(str, "Id");
        Object obj = this.map.get(str);
        return (obj != null || (httpContext = this.parentContext) == null) ? obj : httpContext.getAttribute(str);
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public Object setAttribute(String str, Object obj) {
        Args.notNull(str, "Id");
        if (obj != null) {
            return this.map.put(str, obj);
        }
        return this.map.remove(str);
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        Args.notNull(str, "Id");
        return this.map.remove(str);
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : HttpVersion.DEFAULT;
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
