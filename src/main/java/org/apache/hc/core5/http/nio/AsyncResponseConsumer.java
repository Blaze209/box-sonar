package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncResponseConsumer<T> extends AsyncDataConsumer {
    void consumeResponse(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext, FutureCallback<T> futureCallback) throws HttpException, IOException;

    void failed(Exception exc);

    void informationResponse(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
