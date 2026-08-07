package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpServerRequestHandler;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.support.ExpectSupport;
import org.apache.hc.core5.http.support.Expectation;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpServerExpectationDecorator implements HttpServerRequestHandler {
    private final HttpServerRequestHandler requestHandler;

    protected ClassicHttpResponse verify(ClassicHttpRequest classicHttpRequest, HttpContext httpContext) {
        return null;
    }

    public BasicHttpServerExpectationDecorator(HttpServerRequestHandler httpServerRequestHandler) {
        this.requestHandler = (HttpServerRequestHandler) Args.notNull(httpServerRequestHandler, "Request handler");
    }

    @Override // org.apache.hc.core5.http.io.HttpServerRequestHandler
    public final void handle(ClassicHttpRequest classicHttpRequest, HttpServerRequestHandler.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException {
        Expectation expectation = ExpectSupport.parse(classicHttpRequest, classicHttpRequest.getEntity());
        if (expectation == Expectation.CONTINUE) {
            ClassicHttpResponse classicHttpResponseVerify = verify(classicHttpRequest, httpContext);
            if (classicHttpResponseVerify == null) {
                responseTrigger.sendInformation(new BasicClassicHttpResponse(100));
            } else {
                responseTrigger.submitResponse(classicHttpResponseVerify);
                return;
            }
        } else if (expectation == Expectation.UNKNOWN) {
            responseTrigger.submitResponse(new BasicClassicHttpResponse(417));
            return;
        }
        this.requestHandler.handle(classicHttpRequest, responseTrigger, httpContext);
    }
}
