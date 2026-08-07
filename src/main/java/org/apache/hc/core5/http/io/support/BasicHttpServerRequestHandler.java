package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.impl.io.DefaultClassicHttpResponseFactory;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.HttpServerRequestHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpServerRequestHandler implements HttpServerRequestHandler {
    private final HttpRequestMapper<HttpRequestHandler> handlerMapper;
    private final HttpResponseFactory<ClassicHttpResponse> responseFactory;

    public BasicHttpServerRequestHandler(HttpRequestMapper<HttpRequestHandler> httpRequestMapper, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        this.handlerMapper = (HttpRequestMapper) Args.notNull(httpRequestMapper, "Handler mapper");
        this.responseFactory = httpResponseFactory == null ? DefaultClassicHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    public BasicHttpServerRequestHandler(HttpRequestMapper<HttpRequestHandler> httpRequestMapper) {
        this(httpRequestMapper, null);
    }

    @Override // org.apache.hc.core5.http.io.HttpServerRequestHandler
    public void handle(ClassicHttpRequest classicHttpRequest, HttpServerRequestHandler.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException {
        ClassicHttpResponse classicHttpResponse = (ClassicHttpResponse) this.responseFactory.newHttpResponse(200);
        HttpRequestMapper<HttpRequestHandler> httpRequestMapper = this.handlerMapper;
        HttpRequestHandler httpRequestHandlerResolve = httpRequestMapper != null ? httpRequestMapper.resolve(classicHttpRequest, httpContext) : null;
        if (httpRequestHandlerResolve != null) {
            httpRequestHandlerResolve.handle(classicHttpRequest, classicHttpResponse, httpContext);
        } else {
            classicHttpResponse.setCode(501);
        }
        responseTrigger.submitResponse(classicHttpResponse);
    }
}
