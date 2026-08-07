package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncFilterChain;
import org.apache.hc.core5.http.nio.AsyncFilterHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.support.ExpectSupport;
import org.apache.hc.core5.http.support.Expectation;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncServerExpectationFilter implements AsyncFilterHandler {
    protected AsyncEntityProducer generateResponseContent(HttpResponse httpResponse) throws HttpException {
        return null;
    }

    protected boolean verify(HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        return true;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncFilterHandler
    public final AsyncDataConsumer handle(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, AsyncFilterChain.ResponseTrigger responseTrigger, AsyncFilterChain asyncFilterChain) throws HttpException, IOException {
        Expectation expectation = ExpectSupport.parse(httpRequest, entityDetails);
        if (expectation == Expectation.CONTINUE) {
            if (verify(httpRequest, httpContext)) {
                responseTrigger.sendInformation(new BasicHttpResponse(100));
            } else {
                BasicHttpResponse basicHttpResponse = new BasicHttpResponse(417);
                responseTrigger.submitResponse(basicHttpResponse, generateResponseContent(basicHttpResponse));
                return null;
            }
        } else if (expectation == Expectation.UNKNOWN) {
            BasicHttpResponse basicHttpResponse2 = new BasicHttpResponse(417);
            responseTrigger.submitResponse(basicHttpResponse2, generateResponseContent(basicHttpResponse2));
            return null;
        }
        return asyncFilterChain.proceed(httpRequest, entityDetails, httpContext, responseTrigger);
    }
}
