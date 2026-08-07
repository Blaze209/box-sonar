package org.apache.hc.core5.http.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequestHandler {
    void handle(ClassicHttpRequest classicHttpRequest, ClassicHttpResponse classicHttpResponse, HttpContext httpContext) throws HttpException, IOException;
}
