package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncFilterHandler {
    AsyncDataConsumer handle(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, AsyncFilterChain.ResponseTrigger responseTrigger, AsyncFilterChain asyncFilterChain) throws HttpException, IOException;
}
