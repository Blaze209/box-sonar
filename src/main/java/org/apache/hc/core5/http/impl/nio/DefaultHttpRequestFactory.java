package org.apache.hc.core5.http.impl.nio;

import java.net.URI;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestFactory;
import org.apache.hc.core5.http.message.BasicHttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory<HttpRequest> {
    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();

    @Override // org.apache.hc.core5.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String str, URI uri) {
        return new BasicHttpRequest(str, uri);
    }

    @Override // org.apache.hc.core5.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String str, String str2) {
        return new BasicHttpRequest(str, str2);
    }
}
