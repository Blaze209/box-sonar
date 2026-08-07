package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpFilterChain;
import org.apache.hc.core5.http.io.HttpServerRequestHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class HttpServerFilterChainRequestHandler implements HttpServerRequestHandler {
    private final HttpServerFilterChainElement filterChain;

    public HttpServerFilterChainRequestHandler(HttpServerFilterChainElement httpServerFilterChainElement) {
        this.filterChain = (HttpServerFilterChainElement) Args.notNull(httpServerFilterChainElement, "Filter chain");
    }

    @Override // org.apache.hc.core5.http.io.HttpServerRequestHandler
    public void handle(ClassicHttpRequest classicHttpRequest, final HttpServerRequestHandler.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException {
        this.filterChain.handle(classicHttpRequest, new HttpFilterChain.ResponseTrigger() { // from class: org.apache.hc.core5.http.io.support.HttpServerFilterChainRequestHandler.1
            @Override // org.apache.hc.core5.http.io.HttpFilterChain.ResponseTrigger
            public void sendInformation(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
                responseTrigger.sendInformation(classicHttpResponse);
            }

            @Override // org.apache.hc.core5.http.io.HttpFilterChain.ResponseTrigger
            public void submitResponse(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
                responseTrigger.submitResponse(classicHttpResponse);
            }
        }, httpContext);
    }
}
