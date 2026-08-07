package org.apache.hc.core5.http.nio.support;

import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.MisdirectedRequestException;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultAsyncResponseExchangeHandlerFactory implements HandlerFactory<AsyncServerExchangeHandler> {
    private final Decorator<AsyncServerExchangeHandler> decorator;
    private final HttpRequestMapper<Supplier<AsyncServerExchangeHandler>> mapper;

    public DefaultAsyncResponseExchangeHandlerFactory(HttpRequestMapper<Supplier<AsyncServerExchangeHandler>> httpRequestMapper, Decorator<AsyncServerExchangeHandler> decorator) {
        this.mapper = (HttpRequestMapper) Args.notNull(httpRequestMapper, "Request handler mapper");
        this.decorator = decorator;
    }

    public DefaultAsyncResponseExchangeHandlerFactory(HttpRequestMapper<Supplier<AsyncServerExchangeHandler>> httpRequestMapper) {
        this(httpRequestMapper, null);
    }

    private AsyncServerExchangeHandler createHandler(HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        try {
            Supplier<AsyncServerExchangeHandler> supplierResolve = this.mapper.resolve(httpRequest, httpContext);
            return supplierResolve != null ? supplierResolve.get() : new ImmediateResponseExchangeHandler(404, "Resource not found");
        } catch (MisdirectedRequestException unused) {
            return new ImmediateResponseExchangeHandler(421, "Not authoritative");
        }
    }

    @Override // org.apache.hc.core5.http.nio.HandlerFactory
    public AsyncServerExchangeHandler create(HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        AsyncServerExchangeHandler asyncServerExchangeHandlerCreateHandler = createHandler(httpRequest, httpContext);
        if (asyncServerExchangeHandlerCreateHandler == null) {
            return null;
        }
        Decorator<AsyncServerExchangeHandler> decorator = this.decorator;
        return decorator != null ? decorator.decorate(asyncServerExchangeHandlerCreateHandler) : asyncServerExchangeHandlerCreateHandler;
    }
}
