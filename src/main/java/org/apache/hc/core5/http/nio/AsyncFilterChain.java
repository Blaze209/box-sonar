package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncFilterChain {

    public interface ResponseTrigger {
        void pushPromise(HttpRequest httpRequest, AsyncPushProducer asyncPushProducer) throws HttpException, IOException;

        void sendInformation(HttpResponse httpResponse) throws HttpException, IOException;

        void submitResponse(HttpResponse httpResponse, AsyncEntityProducer asyncEntityProducer) throws HttpException, IOException;
    }

    AsyncDataConsumer proceed(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, ResponseTrigger responseTrigger) throws HttpException, IOException;
}
