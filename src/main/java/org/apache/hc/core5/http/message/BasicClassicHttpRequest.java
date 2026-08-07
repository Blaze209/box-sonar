package org.apache.hc.core5.http.message;

import java.net.URI;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.net.URIAuthority;

/* JADX INFO: loaded from: classes5.dex */
public class BasicClassicHttpRequest extends BasicHttpRequest implements ClassicHttpRequest {
    private static final long serialVersionUID = 1;
    private HttpEntity entity;

    public BasicClassicHttpRequest(String str, String str2, URIAuthority uRIAuthority, String str3) {
        super(str, str2, uRIAuthority, str3);
    }

    public BasicClassicHttpRequest(String str, String str2) {
        super(str, str2);
    }

    public BasicClassicHttpRequest(String str, HttpHost httpHost, String str2) {
        super(str, httpHost, str2);
    }

    public BasicClassicHttpRequest(String str, URI uri) {
        super(str, uri);
    }

    public BasicClassicHttpRequest(Method method, String str) {
        super(method, str);
    }

    public BasicClassicHttpRequest(Method method, HttpHost httpHost, String str) {
        super(method, httpHost, str);
    }

    public BasicClassicHttpRequest(Method method, URI uri) {
        super(method, uri);
    }

    @Override // org.apache.hc.core5.http.HttpEntityContainer
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // org.apache.hc.core5.http.HttpEntityContainer
    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }
}
