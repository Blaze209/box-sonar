package org.apache.hc.core5.http.support;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractRequestBuilder<T> extends AbstractMessageBuilder<T> {
    private boolean absoluteRequestUri;
    private URIAuthority authority;
    private Charset charset;
    private final String method;
    private List<NameValuePair> parameters;
    private String path;
    private String scheme;

    protected AbstractRequestBuilder(String str) {
        this.method = str;
    }

    protected AbstractRequestBuilder(Method method) {
        this(method.name());
    }

    protected AbstractRequestBuilder(String str, URI uri) {
        this.method = str;
        setUri(uri);
    }

    protected AbstractRequestBuilder(Method method, URI uri) {
        this(method.name(), uri);
    }

    protected AbstractRequestBuilder(Method method, String str) {
        this(method.name(), str != null ? URI.create(str) : null);
    }

    protected AbstractRequestBuilder(String str, String str2) {
        this(str, str2 != null ? URI.create(str2) : null);
    }

    protected void digest(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return;
        }
        setScheme(httpRequest.getScheme());
        setAuthority(httpRequest.getAuthority());
        setPath(httpRequest.getPath());
        this.parameters = null;
        super.digest((HttpMessage) httpRequest);
    }

    public String getMethod() {
        return this.method;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    public String getScheme() {
        return this.scheme;
    }

    public AbstractRequestBuilder<T> setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public URIAuthority getAuthority() {
        return this.authority;
    }

    public AbstractRequestBuilder<T> setAuthority(URIAuthority uRIAuthority) {
        this.authority = uRIAuthority;
        return this;
    }

    public AbstractRequestBuilder<T> setHttpHost(HttpHost httpHost) {
        if (httpHost == null) {
            return this;
        }
        this.authority = new URIAuthority(httpHost);
        this.scheme = httpHost.getSchemeName();
        return this;
    }

    public String getPath() {
        return this.path;
    }

    public AbstractRequestBuilder<T> setPath(String str) {
        this.path = str;
        return this;
    }

    public URI getUri() {
        StringBuilder sb = new StringBuilder();
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
        } else {
            if (sb.length() > 0 && !this.path.startsWith("/")) {
                sb.append("/");
            }
            sb.append(this.path);
        }
        return URI.create(sb.toString());
    }

    public AbstractRequestBuilder<T> setUri(URI uri) {
        if (uri == null) {
            this.scheme = null;
            this.authority = null;
            this.path = null;
            return this;
        }
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
        return this;
    }

    public AbstractRequestBuilder<T> setUri(String str) {
        setUri(str != null ? URI.create(str) : null);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AbstractRequestBuilder<T> setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public AbstractRequestBuilder<T> setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public List<NameValuePair> getParameters() {
        if (this.parameters != null) {
            return new ArrayList(this.parameters);
        }
        return null;
    }

    public AbstractRequestBuilder<T> addParameter(NameValuePair nameValuePair) {
        if (nameValuePair == null) {
            return this;
        }
        if (this.parameters == null) {
            this.parameters = new LinkedList();
        }
        this.parameters.add(nameValuePair);
        return this;
    }

    public AbstractRequestBuilder<T> addParameter(String str, String str2) {
        return addParameter(new BasicNameValuePair(str, str2));
    }

    public AbstractRequestBuilder<T> addParameters(NameValuePair... nameValuePairArr) {
        for (NameValuePair nameValuePair : nameValuePairArr) {
            addParameter(nameValuePair);
        }
        return this;
    }

    public boolean isAbsoluteRequestUri() {
        return this.absoluteRequestUri;
    }

    public AbstractRequestBuilder<T> setAbsoluteRequestUri(boolean z) {
        this.absoluteRequestUri = z;
        return this;
    }
}
