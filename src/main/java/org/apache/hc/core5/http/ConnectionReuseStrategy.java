package org.apache.hc.core5.http;

import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext);
}
