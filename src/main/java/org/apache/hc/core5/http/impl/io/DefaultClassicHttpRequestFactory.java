package org.apache.hc.core5.http.impl.io;

import java.net.URI;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpRequestFactory;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultClassicHttpRequestFactory implements HttpRequestFactory<ClassicHttpRequest> {
    public static final DefaultClassicHttpRequestFactory INSTANCE = new DefaultClassicHttpRequestFactory();

    @Override // org.apache.hc.core5.http.HttpRequestFactory
    public ClassicHttpRequest newHttpRequest(String str, URI uri) {
        return new BasicClassicHttpRequest(str, uri);
    }

    @Override // org.apache.hc.core5.http.HttpRequestFactory
    public ClassicHttpRequest newHttpRequest(String str, String str2) {
        return new BasicClassicHttpRequest(str, str2);
    }
}
