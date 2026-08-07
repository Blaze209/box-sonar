package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.HttpFilterChain;
import org.apache.hc.core5.http.io.HttpFilterHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.net.URIAuthority;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHttpServerAuthFilter<T> implements HttpFilterHandler {
    private final boolean respondImmediately;

    protected abstract boolean authenticate(T t, URIAuthority uRIAuthority, String str, HttpContext httpContext);

    protected abstract String generateChallenge(T t, URIAuthority uRIAuthority, String str, HttpContext httpContext);

    protected abstract T parseChallengeResponse(String str, HttpContext httpContext) throws HttpException;

    protected AbstractHttpServerAuthFilter(boolean z) {
        this.respondImmediately = z;
    }

    protected HttpEntity generateResponseContent(HttpResponse httpResponse) {
        return new StringEntity("Unauthorized");
    }

    @Override // org.apache.hc.core5.http.io.HttpFilterHandler
    public final void handle(ClassicHttpRequest classicHttpRequest, HttpFilterChain.ResponseTrigger responseTrigger, HttpContext httpContext, HttpFilterChain httpFilterChain) throws HttpException, IOException {
        Header firstHeader = classicHttpRequest.getFirstHeader("Authorization");
        T challengeResponse = firstHeader != null ? parseChallengeResponse(firstHeader.getValue(), httpContext) : null;
        URIAuthority authority = classicHttpRequest.getAuthority();
        String requestUri = classicHttpRequest.getRequestUri();
        boolean zAuthenticate = authenticate(challengeResponse, authority, requestUri, httpContext);
        Header firstHeader2 = classicHttpRequest.getFirstHeader("Expect");
        boolean z = firstHeader2 != null && "100-continue".equalsIgnoreCase(firstHeader2.getValue());
        if (zAuthenticate) {
            if (z) {
                responseTrigger.sendInformation(new BasicClassicHttpResponse(100));
            }
            httpFilterChain.proceed(classicHttpRequest, responseTrigger, httpContext);
            return;
        }
        BasicClassicHttpResponse basicClassicHttpResponse = new BasicClassicHttpResponse(401);
        basicClassicHttpResponse.addHeader("WWW-Authenticate", generateChallenge(challengeResponse, authority, requestUri, httpContext));
        basicClassicHttpResponse.setEntity(generateResponseContent(basicClassicHttpResponse));
        if (this.respondImmediately || z || classicHttpRequest.getEntity() == null) {
            responseTrigger.submitResponse(basicClassicHttpResponse);
            EntityUtils.consume(classicHttpRequest.getEntity());
        } else {
            EntityUtils.consume(classicHttpRequest.getEntity());
            responseTrigger.submitResponse(basicClassicHttpResponse);
        }
    }
}
