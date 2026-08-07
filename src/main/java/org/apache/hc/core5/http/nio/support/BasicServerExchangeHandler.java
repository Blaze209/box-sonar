package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.nio.AsyncRequestConsumer;
import org.apache.hc.core5.http.nio.AsyncServerRequestHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicServerExchangeHandler<T> extends AbstractServerExchangeHandler<T> {
    private final AsyncServerRequestHandler<T> requestHandler;

    public BasicServerExchangeHandler(AsyncServerRequestHandler<T> asyncServerRequestHandler) {
        this.requestHandler = (AsyncServerRequestHandler) Args.notNull(asyncServerRequestHandler, "Response handler");
    }

    @Override // org.apache.hc.core5.http.nio.support.AbstractServerExchangeHandler
    protected AsyncRequestConsumer<T> supplyConsumer(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException {
        return this.requestHandler.prepare(httpRequest, entityDetails, httpContext);
    }

    @Override // org.apache.hc.core5.http.nio.support.AbstractServerExchangeHandler
    protected void handle(T t, AsyncServerRequestHandler.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException {
        this.requestHandler.handle(t, responseTrigger, httpContext);
    }
}
