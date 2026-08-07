package org.apache.hc.core5.http.nio;

import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.nio.ResourceHolder;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface HandlerFactory<T extends ResourceHolder> {
    T create(HttpRequest httpRequest, HttpContext httpContext) throws HttpException;
}
