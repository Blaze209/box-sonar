package org.apache.hc.core5.http.message;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpRequest extends HeaderGroup implements HttpRequest {
    private static final long serialVersionUID = 1;
    private boolean absoluteRequestUri;
    private URIAuthority authority;
    private final String method;
    private String path;
    private URI requestUri;
    private String scheme;
    private ProtocolVersion version;

    public BasicHttpRequest(String str, String str2, URIAuthority uRIAuthority, String str3) {
        this.method = (String) Args.notNull(str, "Method name");
        this.scheme = str2;
        this.authority = uRIAuthority;
        this.path = str3;
    }

    public BasicHttpRequest(String str, String str2) {
        this.method = str;
        if (str2 != null) {
            try {
                setUri(new URI(str2));
            } catch (URISyntaxException unused) {
                this.path = str2;
            }
        }
    }

    public BasicHttpRequest(String str, HttpHost httpHost, String str2) {
        this.method = (String) Args.notNull(str, "Method name");
        this.scheme = httpHost != null ? httpHost.getSchemeName() : null;
        this.authority = httpHost != null ? new URIAuthority(httpHost) : null;
        this.path = str2;
    }

    public BasicHttpRequest(String str, URI uri) {
        this.method = (String) Args.notNull(str, "Method name");
        setUri((URI) Args.notNull(uri, "Request URI"));
    }

    public BasicHttpRequest(Method method, String str) {
        this.method = ((Method) Args.notNull(method, "Method")).name();
        if (str != null) {
            try {
                setUri(new URI(str));
            } catch (URISyntaxException unused) {
                this.path = str;
            }
        }
    }

    public BasicHttpRequest(Method method, HttpHost httpHost, String str) {
        this.method = ((Method) Args.notNull(method, "Method")).name();
        this.scheme = httpHost != null ? httpHost.getSchemeName() : null;
        this.authority = httpHost != null ? new URIAuthority(httpHost) : null;
        this.path = str;
    }

    public BasicHttpRequest(Method method, URI uri) {
        this.method = ((Method) Args.notNull(method, "Method")).name();
        setUri((URI) Args.notNull(uri, "Request URI"));
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void addHeader(String str, Object obj) {
        Args.notNull(str, "Header name");
        addHeader(new BasicHeader(str, obj));
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setHeader(String str, Object obj) {
        Args.notNull(str, "Header name");
        setHeader(new BasicHeader(str, obj));
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public ProtocolVersion getVersion() {
        return this.version;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getMethod() {
        return this.method;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getPath() {
        return this.path;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setPath(String str) {
        this.path = str;
        this.requestUri = null;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getScheme() {
        return this.scheme;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setScheme(String str) {
        this.scheme = str;
        this.requestUri = null;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public URIAuthority getAuthority() {
        return this.authority;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setAuthority(URIAuthority uRIAuthority) {
        this.authority = uRIAuthority;
        this.requestUri = null;
    }

    public void setAbsoluteRequestUri(boolean z) {
        this.absoluteRequestUri = z;
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getRequestUri() {
        if (this.absoluteRequestUri) {
            StringBuilder sb = new StringBuilder();
            assembleRequestUri(sb);
            return sb.toString();
        }
        return getPath();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setUri(URI uri) {
        this.scheme = uri.getScheme();
        if (uri.getHost() != null) {
            this.authority = new URIAuthority(uri.getRawUserInfo(), uri.getHost(), uri.getPort());
        } else if (uri.getRawAuthority() != null) {
            try {
                this.authority = URIAuthority.create(uri.getRawAuthority());
            } catch (URISyntaxException unused) {
                this.authority = null;
            }
        } else {
            this.authority = null;
        }
        StringBuilder sb = new StringBuilder();
        String rawPath = uri.getRawPath();
        if (!TextUtils.isBlank(rawPath)) {
            sb.append(rawPath);
        } else {
            sb.append("/");
        }
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null) {
            sb.append('?').append(rawQuery);
        }
        this.path = sb.toString();
        this.requestUri = null;
    }

    private void assembleRequestUri(StringBuilder sb) {
        if (this.authority != null) {
            String str = this.scheme;
            if (str == null) {
                str = URIScheme.HTTP.id;
            }
            sb.append(str).append("://");
            sb.append(this.authority.getHostName());
            if (this.authority.getPort() >= 0) {
                sb.append(":").append(this.authority.getPort());
            }
        }
        if (this.path == null) {
            sb.append("/");
            return;
        }
        if (sb.length() > 0 && !this.path.startsWith("/")) {
            sb.append("/");
        }
        sb.append(this.path);
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public URI getUri() throws URISyntaxException {
        if (this.requestUri == null) {
            StringBuilder sb = new StringBuilder();
            assembleRequestUri(sb);
            this.requestUri = new URI(sb.toString());
        }
        return this.requestUri;
    }

    @Override // org.apache.hc.core5.http.message.HeaderGroup
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.method).append(" ");
        assembleRequestUri(sb);
        return sb.toString();
    }
}
