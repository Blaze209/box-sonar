package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncResponseProducer extends AsyncDataProducer {
    void failed(Exception exc);

    void sendResponse(ResponseChannel responseChannel, HttpContext httpContext) throws HttpException, IOException;
}
