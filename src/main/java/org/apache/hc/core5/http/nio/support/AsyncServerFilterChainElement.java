package org.apache.hc.core5.http.nio.support;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.AsyncFilterChain;
import org.apache.hc.core5.http.nio.AsyncFilterHandler;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncServerFilterChainElement {
    private final AsyncFilterChain filterChain;
    private final AsyncFilterHandler handler;
    private final AsyncServerFilterChainElement next;

    public AsyncServerFilterChainElement(AsyncFilterHandler asyncFilterHandler, final AsyncServerFilterChainElement asyncServerFilterChainElement) {
        AsyncFilterChain asyncFilterChain;
        this.handler = asyncFilterHandler;
        this.next = asyncServerFilterChainElement;
        if (asyncServerFilterChainElement != null) {
            asyncServerFilterChainElement.getClass();
            asyncFilterChain = new AsyncFilterChain() { // from class: org.apache.hc.core5.http.nio.support.AsyncServerFilterChainElement$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.http.nio.AsyncFilterChain
                public final AsyncDataConsumer proceed(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, AsyncFilterChain.ResponseTrigger responseTrigger) {
                    return this.f$0.handle(httpRequest, entityDetails, httpContext, responseTrigger);
                }
            };
        } else {
            asyncFilterChain = null;
        }
        this.filterChain = asyncFilterChain;
    }

    public AsyncDataConsumer handle(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext, AsyncFilterChain.ResponseTrigger responseTrigger) throws HttpException, IOException {
        return this.handler.handle(httpRequest, entityDetails, httpContext, responseTrigger, this.filterChain);
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("{handler=").append(this.handler.getClass()).append(", next=");
        AsyncServerFilterChainElement asyncServerFilterChainElement = this.next;
        return sbAppend.append(asyncServerFilterChainElement != null ? asyncServerFilterChainElement.handler.getClass() : AbstractJsonLexerKt.NULL).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
