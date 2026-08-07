package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncRequestProducer extends AsyncDataProducer {
    void failed(Exception exc);

    boolean isRepeatable();

    void sendRequest(RequestChannel requestChannel, HttpContext httpContext) throws HttpException, IOException;
}
