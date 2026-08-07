package org.apache.hc.core5.http.nio.support;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicHttpRequest;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import org.apache.hc.core5.http.nio.entity.BasicAsyncEntityProducer;
import org.apache.hc.core5.http.nio.entity.StringAsyncEntityProducer;
import org.apache.hc.core5.http.support.AbstractRequestBuilder;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.net.WWWFormCodec;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncRequestBuilder extends AbstractRequestBuilder<AsyncRequestProducer> {
    private AsyncEntityProducer entityProducer;

    AsyncRequestBuilder(String str) {
        super(str);
    }

    AsyncRequestBuilder(Method method) {
        super(method);
    }

    AsyncRequestBuilder(String str, URI uri) {
        super(str, uri);
    }

    AsyncRequestBuilder(Method method, URI uri) {
        this(method.name(), uri);
    }

    AsyncRequestBuilder(Method method, String str) {
        this(method.name(), str != null ? URI.create(str) : null);
    }

    AsyncRequestBuilder(String str, String str2) {
        this(str, str2 != null ? URI.create(str2) : null);
    }

    public static AsyncRequestBuilder create(String str) {
        Args.notBlank(str, "HTTP method");
        return new AsyncRequestBuilder(str);
    }

    public static AsyncRequestBuilder get() {
        return new AsyncRequestBuilder(Method.GET);
    }

    public static AsyncRequestBuilder get(URI uri) {
        return new AsyncRequestBuilder(Method.GET, uri);
    }

    public static AsyncRequestBuilder get(String str) {
        return new AsyncRequestBuilder(Method.GET, str);
    }

    public static AsyncRequestBuilder head() {
        return new AsyncRequestBuilder(Method.HEAD);
    }

    public static AsyncRequestBuilder head(URI uri) {
        return new AsyncRequestBuilder(Method.HEAD, uri);
    }

    public static AsyncRequestBuilder head(String str) {
        return new AsyncRequestBuilder(Method.HEAD, str);
    }

    public static AsyncRequestBuilder patch() {
        return new AsyncRequestBuilder(Method.PATCH);
    }

    public static AsyncRequestBuilder patch(URI uri) {
        return new AsyncRequestBuilder(Method.PATCH, uri);
    }

    public static AsyncRequestBuilder patch(String str) {
        return new AsyncRequestBuilder(Method.PATCH, str);
    }

    public static AsyncRequestBuilder post() {
        return new AsyncRequestBuilder(Method.POST);
    }

    public static AsyncRequestBuilder post(URI uri) {
        return new AsyncRequestBuilder(Method.POST, uri);
    }

    public static AsyncRequestBuilder post(String str) {
        return new AsyncRequestBuilder(Method.POST, str);
    }

    public static AsyncRequestBuilder put() {
        return new AsyncRequestBuilder(Method.PUT);
    }

    public static AsyncRequestBuilder put(URI uri) {
        return new AsyncRequestBuilder(Method.PUT, uri);
    }

    public static AsyncRequestBuilder put(String str) {
        return new AsyncRequestBuilder(Method.PUT, str);
    }

    public static AsyncRequestBuilder delete() {
        return new AsyncRequestBuilder(Method.DELETE);
    }

    public static AsyncRequestBuilder delete(URI uri) {
        return new AsyncRequestBuilder(Method.DELETE, uri);
    }

    public static AsyncRequestBuilder delete(String str) {
        return new AsyncRequestBuilder(Method.DELETE, str);
    }

    public static AsyncRequestBuilder trace() {
        return new AsyncRequestBuilder(Method.TRACE);
    }

    public static AsyncRequestBuilder trace(URI uri) {
        return new AsyncRequestBuilder(Method.TRACE, uri);
    }

    public static AsyncRequestBuilder trace(String str) {
        return new AsyncRequestBuilder(Method.TRACE, str);
    }

    public static AsyncRequestBuilder options() {
        return new AsyncRequestBuilder(Method.OPTIONS);
    }

    public static AsyncRequestBuilder options(URI uri) {
        return new AsyncRequestBuilder(Method.OPTIONS, uri);
    }

    public static AsyncRequestBuilder options(String str) {
        return new AsyncRequestBuilder(Method.OPTIONS, str);
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setUri(URI uri) {
        super.setUri(uri);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setUri(String str) {
        super.setUri(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setScheme(String str) {
        super.setScheme(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setAuthority(URIAuthority uRIAuthority) {
        super.setAuthority(uRIAuthority);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setHttpHost(HttpHost httpHost) {
        super.setHttpHost(httpHost);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setPath(String str) {
        super.setPath(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestBuilder setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setCharset(Charset charset) {
        super.setCharset(charset);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> addParameter(NameValuePair nameValuePair) {
        super.addParameter(nameValuePair);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> addParameter(String str, String str2) {
        super.addParameter(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> addParameters(NameValuePair... nameValuePairArr) {
        super.addParameters(nameValuePairArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<AsyncRequestProducer> setAbsoluteRequestUri(boolean z) {
        super.setAbsoluteRequestUri(z);
        return this;
    }

    public AsyncEntityProducer getEntity() {
        return this.entityProducer;
    }

    public AsyncRequestBuilder setEntity(AsyncEntityProducer asyncEntityProducer) {
        this.entityProducer = asyncEntityProducer;
        return this;
    }

    public AsyncRequestBuilder setEntity(String str, ContentType contentType) {
        this.entityProducer = new BasicAsyncEntityProducer(str, contentType);
        return this;
    }

    public AsyncRequestBuilder setEntity(String str) {
        this.entityProducer = new BasicAsyncEntityProducer(str);
        return this;
    }

    public AsyncRequestBuilder setEntity(byte[] bArr, ContentType contentType) {
        this.entityProducer = new BasicAsyncEntityProducer(bArr, contentType);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public AsyncRequestProducer build() {
        String path = getPath();
        if (TextUtils.isEmpty(path)) {
            path = "/";
        }
        AsyncEntityProducer stringAsyncEntityProducer = this.entityProducer;
        String method = getMethod();
        List<NameValuePair> parameters = getParameters();
        if (parameters != null && !parameters.isEmpty()) {
            Charset charset = getCharset();
            if (stringAsyncEntityProducer == null && (Method.POST.isSame(method) || Method.PUT.isSame(method))) {
                if (charset == null) {
                    charset = ContentType.APPLICATION_FORM_URLENCODED.getCharset();
                }
                stringAsyncEntityProducer = new StringAsyncEntityProducer(WWWFormCodec.format(parameters, charset), ContentType.APPLICATION_FORM_URLENCODED);
            } else {
                try {
                    path = new URIBuilder(path).setCharset(charset).addParameters(parameters).build().toASCIIString();
                } catch (URISyntaxException unused) {
                }
            }
        }
        if (stringAsyncEntityProducer != null && Method.TRACE.isSame(method)) {
            throw new IllegalStateException(Method.TRACE + " requests may not include an entity");
        }
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(method, getScheme(), getAuthority(), path);
        basicHttpRequest.setVersion(getVersion());
        basicHttpRequest.setHeaders(getHeaders());
        basicHttpRequest.setAbsoluteRequestUri(isAbsoluteRequestUri());
        return new BasicRequestProducer(basicHttpRequest, stringAsyncEntityProducer);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AsyncRequestBuilder [method=");
        sb.append(getMethod());
        sb.append(", scheme=");
        sb.append(getScheme());
        sb.append(", authority=");
        sb.append(getAuthority());
        sb.append(", path=");
        sb.append(getPath());
        sb.append(", parameters=");
        sb.append(getParameters());
        sb.append(", headerGroup=");
        sb.append(Arrays.toString(getHeaders()));
        sb.append(", entity=");
        AsyncEntityProducer asyncEntityProducer = this.entityProducer;
        sb.append(asyncEntityProducer != null ? asyncEntityProducer.getClass() : null);
        sb.append("]");
        return sb.toString();
    }
}
