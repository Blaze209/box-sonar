package org.apache.hc.core5.http.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpServerConnection extends BHttpConnection {
    void receiveRequestEntity(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException;

    ClassicHttpRequest receiveRequestHeader() throws HttpException, IOException;

    void sendResponseEntity(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException;

    void sendResponseHeader(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException;
}
