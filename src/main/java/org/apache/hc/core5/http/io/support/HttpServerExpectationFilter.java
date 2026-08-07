package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.HttpFilterChain;
import org.apache.hc.core5.http.io.HttpFilterHandler;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.support.ExpectSupport;
import org.apache.hc.core5.http.support.Expectation;

/* JADX INFO: loaded from: classes5.dex */
public class HttpServerExpectationFilter implements HttpFilterHandler {
    protected HttpEntity generateResponseContent(HttpResponse httpResponse) throws HttpException {
        return null;
    }

    protected boolean verify(ClassicHttpRequest classicHttpRequest, HttpContext httpContext) throws HttpException {
        return true;
    }

    @Override // org.apache.hc.core5.http.io.HttpFilterHandler
    public final void handle(ClassicHttpRequest classicHttpRequest, HttpFilterChain.ResponseTrigger responseTrigger, HttpContext httpContext, HttpFilterChain httpFilterChain) throws HttpException, IOException {
        Expectation expectation = ExpectSupport.parse(classicHttpRequest, classicHttpRequest.getEntity());
        if (expectation == Expectation.CONTINUE) {
            if (verify(classicHttpRequest, httpContext)) {
                responseTrigger.sendInformation(new BasicClassicHttpResponse(100));
            } else {
                BasicClassicHttpResponse basicClassicHttpResponse = new BasicClassicHttpResponse(417);
                basicClassicHttpResponse.setEntity(generateResponseContent(basicClassicHttpResponse));
                responseTrigger.submitResponse(basicClassicHttpResponse);
                return;
            }
        } else if (expectation == Expectation.UNKNOWN) {
            BasicClassicHttpResponse basicClassicHttpResponse2 = new BasicClassicHttpResponse(417);
            basicClassicHttpResponse2.setEntity(generateResponseContent(basicClassicHttpResponse2));
            responseTrigger.submitResponse(basicClassicHttpResponse2);
            return;
        }
        httpFilterChain.proceed(classicHttpRequest, responseTrigger, httpContext);
    }
}
