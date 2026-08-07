package org.apache.hc.core5.http.protocol;

import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class HttpCoreContext implements HttpContext {

    @Deprecated
    public static final String CONNECTION_ENDPOINT = "http.connection-endpoint";

    @Deprecated
    public static final String HTTP_REQUEST = "http.request";

    @Deprecated
    public static final String HTTP_RESPONSE = "http.response";

    @Deprecated
    public static final String SSL_SESSION = "http.ssl-session";
    private EndpointDetails endpointDetails;
    private Map<String, Object> map;
    private final HttpContext parentContext;
    private HttpRequest request;
    private HttpResponse response;
    private SSLSession sslSession;
    private ProtocolVersion version;

    public static HttpCoreContext create() {
        return new HttpCoreContext();
    }

    @Deprecated
    public static HttpCoreContext adapt(HttpContext httpContext) {
        if (httpContext == null) {
            return new HttpCoreContext();
        }
        if (httpContext instanceof HttpCoreContext) {
            return (HttpCoreContext) httpContext;
        }
        return new HttpCoreContext(httpContext);
    }

    public static HttpCoreContext cast(HttpContext httpContext) {
        if (httpContext == null) {
            return null;
        }
        return httpContext instanceof HttpCoreContext ? (HttpCoreContext) httpContext : new Delegate(httpContext);
    }

    public static HttpCoreContext castOrCreate(HttpContext httpContext) {
        return httpContext != null ? cast(httpContext) : create();
    }

    public HttpCoreContext(HttpContext httpContext) {
        this.parentContext = httpContext;
    }

    public HttpCoreContext() {
        this.parentContext = null;
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : HttpVersion.HTTP_1_1;
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public Object getAttribute(String str) {
        HttpContext httpContext;
        Map<String, Object> map = this.map;
        Object obj = map != null ? map.get(str) : null;
        return (obj != null || (httpContext = this.parentContext) == null) ? obj : httpContext.getAttribute(str);
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public Object setAttribute(String str, Object obj) {
        if (this.map == null) {
            this.map = new HashMap();
        }
        return this.map.put(str, obj);
    }

    @Override // org.apache.hc.core5.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        Map<String, Object> map = this.map;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }

    public <T> T getAttribute(String str, Class<T> cls) {
        Args.notNull(cls, "Attribute class");
        Object attribute = getAttribute(str);
        if (attribute != null) {
            return cls.cast(attribute);
        }
        return null;
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public void setRequest(HttpRequest httpRequest) {
        this.request = httpRequest;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public void setResponse(HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    public EndpointDetails getEndpointDetails() {
        return this.endpointDetails;
    }

    public void setEndpointDetails(EndpointDetails endpointDetails) {
        this.endpointDetails = endpointDetails;
    }

    public SSLSession getSSLSession() {
        return this.sslSession;
    }

    public void setSSLSession(SSLSession sSLSession) {
        this.sslSession = sSLSession;
    }

    static class Delegate extends HttpCoreContext {
        private final HttpContext httpContext;

        Delegate(HttpContext httpContext) {
            super(null);
            this.httpContext = httpContext;
        }

        <T> T getAttr(String str, Class<T> cls) {
            Object attribute = this.httpContext.getAttribute(str);
            if (attribute == null) {
                return null;
            }
            return cls.cast(attribute);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public HttpRequest getRequest() {
            return (HttpRequest) getAttr("http.request", HttpRequest.class);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public void setRequest(HttpRequest httpRequest) {
            this.httpContext.setAttribute("http.request", httpRequest);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public HttpResponse getResponse() {
            return (HttpResponse) getAttr("http.response", HttpResponse.class);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public void setResponse(HttpResponse httpResponse) {
            this.httpContext.setAttribute("http.response", httpResponse);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public EndpointDetails getEndpointDetails() {
            return (EndpointDetails) getAttr(HttpCoreContext.CONNECTION_ENDPOINT, EndpointDetails.class);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public void setEndpointDetails(EndpointDetails endpointDetails) {
            this.httpContext.setAttribute(HttpCoreContext.CONNECTION_ENDPOINT, endpointDetails);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public SSLSession getSSLSession() {
            return (SSLSession) getAttr(HttpCoreContext.SSL_SESSION, SSLSession.class);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public void setSSLSession(SSLSession sSLSession) {
            this.httpContext.setAttribute(HttpCoreContext.SSL_SESSION, sSLSession);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext, org.apache.hc.core5.http.protocol.HttpContext
        public ProtocolVersion getProtocolVersion() {
            return this.httpContext.getProtocolVersion();
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext, org.apache.hc.core5.http.protocol.HttpContext
        public void setProtocolVersion(ProtocolVersion protocolVersion) {
            this.httpContext.setProtocolVersion(protocolVersion);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext, org.apache.hc.core5.http.protocol.HttpContext
        public Object getAttribute(String str) {
            return this.httpContext.getAttribute(str);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext, org.apache.hc.core5.http.protocol.HttpContext
        public Object setAttribute(String str, Object obj) {
            return this.httpContext.setAttribute(str, obj);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext, org.apache.hc.core5.http.protocol.HttpContext
        public Object removeAttribute(String str) {
            return this.httpContext.removeAttribute(str);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public <T> T getAttribute(String str, Class<T> cls) {
            return (T) getAttr(str, cls);
        }

        @Override // org.apache.hc.core5.http.protocol.HttpCoreContext
        public String toString() {
            return this.httpContext.toString();
        }
    }

    public String toString() {
        return "HttpCoreContext{version=" + this.version + ", request=" + this.request + ", response=" + this.response + ", endpointDetails=" + this.endpointDetails + ", sslSession=" + this.sslSession + AbstractJsonLexerKt.END_OBJ;
    }
}
