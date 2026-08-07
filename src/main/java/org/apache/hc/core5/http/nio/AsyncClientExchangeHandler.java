package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncClientExchangeHandler extends AsyncDataExchangeHandler {
    void cancel();

    void consumeInformation(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;

    void consumeResponse(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException;

    void produceRequest(RequestChannel requestChannel, HttpContext httpContext) throws HttpException, IOException;
}
