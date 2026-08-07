package org.apache.hc.core5.http.support;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicHttpRequest;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicRequestBuilder extends AbstractRequestBuilder<BasicHttpRequest> {
    BasicRequestBuilder(String str) {
        super(str);
    }

    BasicRequestBuilder(Method method) {
        super(method);
    }

    BasicRequestBuilder(String str, URI uri) {
        super(str, uri);
    }

    BasicRequestBuilder(Method method, URI uri) {
        super(method, uri);
    }

    BasicRequestBuilder(Method method, String str) {
        super(method, str);
    }

    BasicRequestBuilder(String str, String str2) {
        super(str, str2);
    }

    public static BasicRequestBuilder create(String str) {
        Args.notBlank(str, "HTTP method");
        return new BasicRequestBuilder(str);
    }

    public static BasicRequestBuilder get() {
        return new BasicRequestBuilder(Method.GET);
    }

    public static BasicRequestBuilder get(URI uri) {
        return new BasicRequestBuilder(Method.GET, uri);
    }

    public static BasicRequestBuilder get(String str) {
        return new BasicRequestBuilder(Method.GET, str);
    }

    public static BasicRequestBuilder head() {
        return new BasicRequestBuilder(Method.HEAD);
    }

    public static BasicRequestBuilder head(URI uri) {
        return new BasicRequestBuilder(Method.HEAD, uri);
    }

    public static BasicRequestBuilder head(String str) {
        return new BasicRequestBuilder(Method.HEAD, str);
    }

    public static BasicRequestBuilder patch() {
        return new BasicRequestBuilder(Method.PATCH);
    }

    public static BasicRequestBuilder patch(URI uri) {
        return new BasicRequestBuilder(Method.PATCH, uri);
    }

    public static BasicRequestBuilder patch(String str) {
        return new BasicRequestBuilder(Method.PATCH, str);
    }

    public static BasicRequestBuilder post() {
        return new BasicRequestBuilder(Method.POST);
    }

    public static BasicRequestBuilder post(URI uri) {
        return new BasicRequestBuilder(Method.POST, uri);
    }

    public static BasicRequestBuilder post(String str) {
        return new BasicRequestBuilder(Method.POST, str);
    }

    public static BasicRequestBuilder put() {
        return new BasicRequestBuilder(Method.PUT);
    }

    public static BasicRequestBuilder put(URI uri) {
        return new BasicRequestBuilder(Method.PUT, uri);
    }

    public static BasicRequestBuilder put(String str) {
        return new BasicRequestBuilder(Method.PUT, str);
    }

    public static BasicRequestBuilder delete() {
        return new BasicRequestBuilder(Method.DELETE);
    }

    public static BasicRequestBuilder delete(URI uri) {
        return new BasicRequestBuilder(Method.DELETE, uri);
    }

    public static BasicRequestBuilder delete(String str) {
        return new BasicRequestBuilder(Method.DELETE, str);
    }

    public static BasicRequestBuilder trace() {
        return new BasicRequestBuilder(Method.TRACE);
    }

    public static BasicRequestBuilder trace(URI uri) {
        return new BasicRequestBuilder(Method.TRACE, uri);
    }

    public static BasicRequestBuilder trace(String str) {
        return new BasicRequestBuilder(Method.TRACE, str);
    }

    public static BasicRequestBuilder options() {
        return new BasicRequestBuilder(Method.OPTIONS);
    }

    public static BasicRequestBuilder options(URI uri) {
        return new BasicRequestBuilder(Method.OPTIONS, uri);
    }

    public static BasicRequestBuilder options(String str) {
        return new BasicRequestBuilder(Method.OPTIONS, str);
    }

    public static BasicRequestBuilder copy(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        BasicRequestBuilder basicRequestBuilder = new BasicRequestBuilder(httpRequest.getMethod());
        basicRequestBuilder.digest(httpRequest);
        return basicRequestBuilder;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setUri(URI uri) {
        super.setUri(uri);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setUri(String str) {
        super.setUri(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setScheme(String str) {
        super.setScheme(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setAuthority(URIAuthority uRIAuthority) {
        super.setAuthority(uRIAuthority);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setHttpHost(HttpHost httpHost) {
        super.setHttpHost(httpHost);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setPath(String str) {
        super.setPath(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicRequestBuilder setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setCharset(Charset charset) {
        super.setCharset(charset);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> addParameter(NameValuePair nameValuePair) {
        super.addParameter(nameValuePair);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> addParameter(String str, String str2) {
        super.addParameter(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> addParameters(NameValuePair... nameValuePairArr) {
        super.addParameters(nameValuePairArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<BasicHttpRequest> setAbsoluteRequestUri(boolean z) {
        super.setAbsoluteRequestUri(z);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public BasicHttpRequest build() {
        String path = getPath();
        List<NameValuePair> parameters = getParameters();
        if (parameters != null && !parameters.isEmpty()) {
            try {
                path = new URIBuilder(path).setCharset(getCharset()).addParameters(parameters).build().toASCIIString();
            } catch (URISyntaxException unused) {
            }
        }
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(getMethod(), getScheme(), getAuthority(), path);
        basicHttpRequest.setVersion(getVersion());
        basicHttpRequest.setHeaders(getHeaders());
        basicHttpRequest.setAbsoluteRequestUri(isAbsoluteRequestUri());
        return basicHttpRequest;
    }

    public String toString() {
        return "BasicRequestBuilder [method=" + getMethod() + ", scheme=" + getScheme() + ", authority=" + getAuthority() + ", path=" + getPath() + ", parameters=" + getParameters() + ", headerGroup=" + Arrays.toString(getHeaders()) + "]";
    }
}
