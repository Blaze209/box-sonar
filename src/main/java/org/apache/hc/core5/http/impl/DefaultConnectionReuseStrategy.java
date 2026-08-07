package org.apache.hc.core5.http.impl;

import java.util.Iterator;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicTokenIterator;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    @Override // org.apache.hc.core5.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        if (httpRequest != null) {
            if (httpRequest.containsHeader("Content-Length") && httpRequest.containsHeader("Transfer-Encoding")) {
                return false;
            }
            Iterator<String> itIterateTokens = MessageSupport.iterateTokens(httpRequest, "Connection");
            while (itIterateTokens.hasNext()) {
                if (HeaderElements.CLOSE.equalsIgnoreCase(itIterateTokens.next())) {
                    return false;
                }
            }
        }
        Header firstHeader = httpResponse.getFirstHeader("Transfer-Encoding");
        if (firstHeader == null) {
            if (MessageSupport.canResponseHaveBody(httpRequest != null ? httpRequest.getMethod() : null, httpResponse) && httpResponse.countHeaders("Content-Length") != 1) {
                return false;
            }
        }
        ProtocolVersion version = httpResponse.getVersion() != null ? httpResponse.getVersion() : httpContext.getProtocolVersion();
        if (version.lessEquals(HttpVersion.HTTP_1_0) && firstHeader != null) {
            return false;
        }
        if (httpResponse.getCode() == 204) {
            Header firstHeader2 = httpResponse.getFirstHeader("Content-Length");
            if (firstHeader2 != null) {
                try {
                    if (Long.parseLong(firstHeader2.getValue()) > 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (httpResponse.containsHeader("Transfer-Encoding")) {
                return false;
            }
        }
        Iterator<Header> itHeaderIterator = httpResponse.headerIterator("Connection");
        if (!itHeaderIterator.hasNext()) {
            itHeaderIterator = httpResponse.headerIterator(HttpHeaders.PROXY_CONNECTION);
        }
        if (itHeaderIterator.hasNext()) {
            if (version.greaterEquals(HttpVersion.HTTP_1_1)) {
                BasicTokenIterator basicTokenIterator = new BasicTokenIterator(itHeaderIterator);
                while (basicTokenIterator.hasNext()) {
                    if (HeaderElements.CLOSE.equalsIgnoreCase(basicTokenIterator.next())) {
                        return false;
                    }
                }
                return true;
            }
            BasicTokenIterator basicTokenIterator2 = new BasicTokenIterator(itHeaderIterator);
            while (basicTokenIterator2.hasNext()) {
                if (HeaderElements.KEEP_ALIVE.equalsIgnoreCase(basicTokenIterator2.next())) {
                    return true;
                }
            }
            return false;
        }
        return version.greaterEquals(HttpVersion.HTTP_1_1);
    }
}
