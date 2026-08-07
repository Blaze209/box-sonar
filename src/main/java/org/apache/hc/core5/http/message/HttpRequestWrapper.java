package org.apache.hc.core5.http.message;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.net.URIAuthority;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequestWrapper extends AbstractMessageWrapper<HttpRequest> implements HttpRequest {
    public HttpRequestWrapper(HttpRequest httpRequest) {
        super(httpRequest);
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getMethod() {
        return getMessage().getMethod();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getPath() {
        return getMessage().getPath();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setPath(String str) {
        getMessage().setPath(str);
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getScheme() {
        return getMessage().getScheme();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setScheme(String str) {
        getMessage().setScheme(str);
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public URIAuthority getAuthority() {
        return getMessage().getAuthority();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setAuthority(URIAuthority uRIAuthority) {
        getMessage().setAuthority(uRIAuthority);
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public String getRequestUri() {
        return getMessage().getRequestUri();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public URI getUri() throws URISyntaxException {
        return getMessage().getUri();
    }

    @Override // org.apache.hc.core5.http.HttpRequest
    public void setUri(URI uri) {
        getMessage().setUri(uri);
    }
}
