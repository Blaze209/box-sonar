package org.apache.hc.core5.http.io.support;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpFilterChain;
import org.apache.hc.core5.http.io.HttpFilterHandler;
import org.apache.hc.core5.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpServerFilterChainElement {
    private final HttpFilterChain filterChain;
    private final HttpFilterHandler handler;
    private final HttpServerFilterChainElement next;

    public HttpServerFilterChainElement(HttpFilterHandler httpFilterHandler, final HttpServerFilterChainElement httpServerFilterChainElement) {
        HttpFilterChain httpFilterChain;
        this.handler = httpFilterHandler;
        this.next = httpServerFilterChainElement;
        if (httpServerFilterChainElement != null) {
            httpServerFilterChainElement.getClass();
            httpFilterChain = new HttpFilterChain() { // from class: org.apache.hc.core5.http.io.support.HttpServerFilterChainElement$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.http.io.HttpFilterChain
                public final void proceed(ClassicHttpRequest classicHttpRequest, HttpFilterChain.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException {
                    this.f$0.handle(classicHttpRequest, responseTrigger, httpContext);
                }
            };
        } else {
            httpFilterChain = null;
        }
        this.filterChain = httpFilterChain;
    }

    public void handle(ClassicHttpRequest classicHttpRequest, HttpFilterChain.ResponseTrigger responseTrigger, HttpContext httpContext) throws HttpException, IOException {
        this.handler.handle(classicHttpRequest, responseTrigger, httpContext, this.filterChain);
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("{handler=").append(this.handler.getClass()).append(", next=");
        HttpServerFilterChainElement httpServerFilterChainElement = this.next;
        return sbAppend.append(httpServerFilterChainElement != null ? httpServerFilterChainElement.handler.getClass() : AbstractJsonLexerKt.NULL).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
