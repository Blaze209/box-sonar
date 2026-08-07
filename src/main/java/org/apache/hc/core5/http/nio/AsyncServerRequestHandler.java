package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncServerRequestHandler<T> {

    public interface ResponseTrigger {
        void pushPromise(HttpRequest httpRequest, HttpContext httpContext, AsyncPushProducer asyncPushProducer) throws HttpException, IOException;

        void sendInformation(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;

        void submitResponse(AsyncResponseProducer asyncResponseProducer, HttpContext httpContext) throws HttpException, IOException;
    }

    void handle(T t, ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException;

    AsyncRequestConsumer<T> prepare(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException;
}
