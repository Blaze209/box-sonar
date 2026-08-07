package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncServerExchangeHandler extends AsyncDataExchangeHandler {
    void handleRequest(HttpRequest httpRequest, EntityDetails entityDetails, ResponseChannel responseChannel, HttpContext httpContext) throws HttpException, IOException;
}
