package org.apache.hc.core5.http.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClientConnection extends BHttpConnection {
    boolean isConsistent();

    void receiveResponseEntity(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException;

    ClassicHttpResponse receiveResponseHeader() throws HttpException, IOException;

    void sendRequestEntity(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException;

    void sendRequestHeader(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException;

    void terminateRequest(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException;
}
