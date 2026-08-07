package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.AsyncFilterChain;
import org.apache.hc.core5.http.nio.AsyncFilterHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.entity.AsyncEntityProducers;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.net.URIAuthority;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAsyncServerAuthFilter<T> implements AsyncFilterHandler {
    private final boolean respondImmediately;

    protected abstract boolean authenticate(T t, URIAuthority uRIAuthority, String str, HttpContext httpContext);

    protected abstract String generateChallenge(T t, URIAuthority uRIAuthority, String str, HttpContext httpContext);

    protected abstract T parseChallengeResponse(String str, HttpContext httpContext) throws HttpException;

    protected AbstractAsyncServerAuthFilter(boolean z) {
        this.respondImmediately = z;
    }

    protected AsyncEntityProducer generateResponseContent(HttpResponse httpResponse) {
        return AsyncEntityProducers.create("Unauthorized");
    }

    @Override // org.apache.hc.core5.http.nio.AsyncFilterHandler
    public final AsyncDataConsumer handle(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, final AsyncFilterChain.ResponseTrigger responseTrigger, AsyncFilterChain asyncFilterChain) throws HttpException, IOException {
        Header firstHeader = httpRequest.getFirstHeader("Authorization");
        T challengeResponse = firstHeader != null ? parseChallengeResponse(firstHeader.getValue(), httpContext) : null;
        URIAuthority authority = httpRequest.getAuthority();
        String requestUri = httpRequest.getRequestUri();
        boolean zAuthenticate = authenticate(challengeResponse, authority, requestUri, httpContext);
        Header firstHeader2 = httpRequest.getFirstHeader("Expect");
        boolean z = firstHeader2 != null && "100-continue".equalsIgnoreCase(firstHeader2.getValue());
        if (zAuthenticate) {
            if (z) {
                responseTrigger.sendInformation(new BasicClassicHttpResponse(100));
            }
            return asyncFilterChain.proceed(httpRequest, entityDetails, httpContext, responseTrigger);
        }
        final BasicHttpResponse basicHttpResponse = new BasicHttpResponse(401);
        basicHttpResponse.addHeader("WWW-Authenticate", generateChallenge(challengeResponse, authority, requestUri, httpContext));
        final AsyncEntityProducer asyncEntityProducerGenerateResponseContent = generateResponseContent(basicHttpResponse);
        if (this.respondImmediately || z || entityDetails == null) {
            responseTrigger.submitResponse(basicHttpResponse, asyncEntityProducerGenerateResponseContent);
            return null;
        }
        return new AsyncDataConsumer() { // from class: org.apache.hc.core5.http.nio.support.AbstractAsyncServerAuthFilter.1
            @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
            public void consume(ByteBuffer byteBuffer) throws IOException {
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
            public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
                capacityChannel.update(Integer.MAX_VALUE);
            }

            @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
            public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
                responseTrigger.submitResponse(basicHttpResponse, asyncEntityProducerGenerateResponseContent);
            }

            @Override // org.apache.hc.core5.http.nio.ResourceHolder
            public void releaseResources() {
                AsyncEntityProducer asyncEntityProducer = asyncEntityProducerGenerateResponseContent;
                if (asyncEntityProducer != null) {
                    asyncEntityProducer.releaseResources();
                }
            }
        };
    }
}
