package org.apache.hc.core5.http.io.support;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.HttpEntities;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;
import org.apache.hc.core5.http.support.AbstractRequestBuilder;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ClassicRequestBuilder extends AbstractRequestBuilder<ClassicHttpRequest> {
    private HttpEntity entity;

    ClassicRequestBuilder(String str) {
        super(str);
    }

    ClassicRequestBuilder(Method method) {
        super(method);
    }

    ClassicRequestBuilder(String str, URI uri) {
        super(str, uri);
    }

    ClassicRequestBuilder(Method method, URI uri) {
        super(method, uri);
    }

    ClassicRequestBuilder(Method method, String str) {
        super(method, str);
    }

    ClassicRequestBuilder(String str, String str2) {
        super(str, str2);
    }

    public static ClassicRequestBuilder create(String str) {
        Args.notBlank(str, "HTTP method");
        return new ClassicRequestBuilder(str);
    }

    public static ClassicRequestBuilder get() {
        return new ClassicRequestBuilder(Method.GET);
    }

    public static ClassicRequestBuilder get(URI uri) {
        return new ClassicRequestBuilder(Method.GET, uri);
    }

    public static ClassicRequestBuilder get(String str) {
        return new ClassicRequestBuilder(Method.GET, str);
    }

    public static ClassicRequestBuilder head() {
        return new ClassicRequestBuilder(Method.HEAD);
    }

    public static ClassicRequestBuilder head(URI uri) {
        return new ClassicRequestBuilder(Method.HEAD, uri);
    }

    public static ClassicRequestBuilder head(String str) {
        return new ClassicRequestBuilder(Method.HEAD, str);
    }

    public static ClassicRequestBuilder patch() {
        return new ClassicRequestBuilder(Method.PATCH);
    }

    public static ClassicRequestBuilder patch(URI uri) {
        return new ClassicRequestBuilder(Method.PATCH, uri);
    }

    public static ClassicRequestBuilder patch(String str) {
        return new ClassicRequestBuilder(Method.PATCH, str);
    }

    public static ClassicRequestBuilder post() {
        return new ClassicRequestBuilder(Method.POST);
    }

    public static ClassicRequestBuilder post(URI uri) {
        return new ClassicRequestBuilder(Method.POST, uri);
    }

    public static ClassicRequestBuilder post(String str) {
        return new ClassicRequestBuilder(Method.POST, str);
    }

    public static ClassicRequestBuilder put() {
        return new ClassicRequestBuilder(Method.PUT);
    }

    public static ClassicRequestBuilder put(URI uri) {
        return new ClassicRequestBuilder(Method.PUT, uri);
    }

    public static ClassicRequestBuilder put(String str) {
        return new ClassicRequestBuilder(Method.PUT, str);
    }

    public static ClassicRequestBuilder delete() {
        return new ClassicRequestBuilder(Method.DELETE);
    }

    public static ClassicRequestBuilder delete(URI uri) {
        return new ClassicRequestBuilder(Method.DELETE, uri);
    }

    public static ClassicRequestBuilder delete(String str) {
        return new ClassicRequestBuilder(Method.DELETE, str);
    }

    public static ClassicRequestBuilder trace() {
        return new ClassicRequestBuilder(Method.TRACE);
    }

    public static ClassicRequestBuilder trace(URI uri) {
        return new ClassicRequestBuilder(Method.TRACE, uri);
    }

    public static ClassicRequestBuilder trace(String str) {
        return new ClassicRequestBuilder(Method.TRACE, str);
    }

    public static ClassicRequestBuilder options() {
        return new ClassicRequestBuilder(Method.OPTIONS);
    }

    public static ClassicRequestBuilder options(URI uri) {
        return new ClassicRequestBuilder(Method.OPTIONS, uri);
    }

    public static ClassicRequestBuilder options(String str) {
        return new ClassicRequestBuilder(Method.OPTIONS, str);
    }

    public static ClassicRequestBuilder copy(ClassicHttpRequest classicHttpRequest) {
        Args.notNull(classicHttpRequest, "HTTP request");
        ClassicRequestBuilder classicRequestBuilder = new ClassicRequestBuilder(classicHttpRequest.getMethod());
        classicRequestBuilder.digest(classicHttpRequest);
        return classicRequestBuilder;
    }

    protected void digest(ClassicHttpRequest classicHttpRequest) {
        super.digest((HttpRequest) classicHttpRequest);
        setEntity(classicHttpRequest.getEntity());
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder setVersion(ProtocolVersion protocolVersion) {
        super.setVersion(protocolVersion);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setUri(URI uri) {
        super.setUri(uri);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setUri(String str) {
        super.setUri(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setScheme(String str) {
        super.setScheme(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setAuthority(URIAuthority uRIAuthority) {
        super.setAuthority(uRIAuthority);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setHttpHost(HttpHost httpHost) {
        super.setHttpHost(httpHost);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setPath(String str) {
        super.setPath(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder setHeaders(Header... headerArr) {
        super.setHeaders(headerArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder addHeader(Header header) {
        super.addHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder addHeader(String str, String str2) {
        super.addHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder removeHeader(Header header) {
        super.removeHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder removeHeaders(String str) {
        super.removeHeaders(str);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder setHeader(Header header) {
        super.setHeader(header);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder, org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicRequestBuilder setHeader(String str, String str2) {
        super.setHeader(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setCharset(Charset charset) {
        super.setCharset(charset);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> addParameter(NameValuePair nameValuePair) {
        super.addParameter(nameValuePair);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> addParameter(String str, String str2) {
        super.addParameter(str, str2);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> addParameters(NameValuePair... nameValuePairArr) {
        super.addParameters(nameValuePairArr);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractRequestBuilder
    public AbstractRequestBuilder<ClassicHttpRequest> setAbsoluteRequestUri(boolean z) {
        super.setAbsoluteRequestUri(z);
        return this;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public ClassicRequestBuilder setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
        return this;
    }

    public ClassicRequestBuilder setEntity(String str, ContentType contentType) {
        this.entity = new StringEntity(str, contentType);
        return this;
    }

    public ClassicRequestBuilder setEntity(String str) {
        this.entity = new StringEntity(str);
        return this;
    }

    public ClassicRequestBuilder setEntity(byte[] bArr, ContentType contentType) {
        this.entity = new ByteArrayEntity(bArr, contentType);
        return this;
    }

    @Override // org.apache.hc.core5.http.support.AbstractMessageBuilder
    public ClassicHttpRequest build() {
        String path = getPath();
        if (TextUtils.isEmpty(path)) {
            path = "/";
        }
        HttpEntity httpEntityCreateUrlEncoded = this.entity;
        String method = getMethod();
        List<NameValuePair> parameters = getParameters();
        if (parameters != null && !parameters.isEmpty()) {
            if (httpEntityCreateUrlEncoded == null && (Method.POST.isSame(method) || Method.PUT.isSame(method))) {
                httpEntityCreateUrlEncoded = HttpEntities.createUrlEncoded(parameters, getCharset());
            } else {
                try {
                    path = new URIBuilder(path).setCharset(getCharset()).addParameters(parameters).build().toASCIIString();
                } catch (URISyntaxException unused) {
                }
            }
        }
        if (httpEntityCreateUrlEncoded != null && Method.TRACE.isSame(method)) {
            throw new IllegalStateException(Method.TRACE + " requests may not include an entity");
        }
        BasicClassicHttpRequest basicClassicHttpRequest = new BasicClassicHttpRequest(method, getScheme(), getAuthority(), path);
        basicClassicHttpRequest.setVersion(getVersion());
        basicClassicHttpRequest.setHeaders(getHeaders());
        basicClassicHttpRequest.setEntity(httpEntityCreateUrlEncoded);
        basicClassicHttpRequest.setAbsoluteRequestUri(isAbsoluteRequestUri());
        return basicClassicHttpRequest;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClassicRequestBuilder [method=");
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
        HttpEntity httpEntity = this.entity;
        sb.append(httpEntity != null ? httpEntity.getClass() : null);
        sb.append("]");
        return sb.toString();
    }
}
