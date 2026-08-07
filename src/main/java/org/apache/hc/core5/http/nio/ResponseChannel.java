package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface ResponseChannel {
    void pushPromise(HttpRequest httpRequest, AsyncPushProducer asyncPushProducer, HttpContext httpContext) throws HttpException, IOException;

    void sendInformation(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;

    void sendResponse(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException;
}
