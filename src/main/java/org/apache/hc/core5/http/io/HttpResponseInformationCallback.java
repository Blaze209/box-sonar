package org.apache.hc.core5.http.io;

import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponseInformationCallback {
    void execute(HttpResponse httpResponse, HttpConnection httpConnection, HttpContext httpContext) throws HttpException;
}
