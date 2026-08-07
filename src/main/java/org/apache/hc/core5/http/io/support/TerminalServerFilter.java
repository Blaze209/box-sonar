package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.impl.io.DefaultClassicHttpResponseFactory;
import org.apache.hc.core5.http.io.HttpFilterChain;
import org.apache.hc.core5.http.io.HttpFilterHandler;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class TerminalServerFilter implements HttpFilterHandler {
    private final HttpRequestMapper<HttpRequestHandler> handlerMapper;
    private final HttpResponseFactory<ClassicHttpResponse> responseFactory;

    public TerminalServerFilter(HttpRequestMapper<HttpRequestHandler> httpRequestMapper, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        this.handlerMapper = (HttpRequestMapper) Args.notNull(httpRequestMapper, "Handler mapper");
        this.responseFactory = httpResponseFactory == null ? DefaultClassicHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    @Override // org.apache.hc.core5.http.io.HttpFilterHandler
    public void handle(ClassicHttpRequest classicHttpRequest, HttpFilterChain.ResponseTrigger responseTrigger, HttpContext httpContext, HttpFilterChain httpFilterChain) throws HttpException, IOException {
        ClassicHttpResponse classicHttpResponse = (ClassicHttpResponse) this.responseFactory.newHttpResponse(200);
        HttpRequestHandler httpRequestHandlerResolve = this.handlerMapper.resolve(classicHttpRequest, httpContext);
        if (httpRequestHandlerResolve != null) {
            httpRequestHandlerResolve.handle(classicHttpRequest, classicHttpResponse, httpContext);
        } else {
            classicHttpResponse.setCode(501);
        }
        responseTrigger.submitResponse(classicHttpResponse);
    }
}
