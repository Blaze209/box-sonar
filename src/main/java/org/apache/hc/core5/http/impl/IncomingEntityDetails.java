package org.apache.hc.core5.http.impl;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.Collections;
import java.util.Set;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.MessageHeaders;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class IncomingEntityDetails implements EntityDetails {
    private final long contentLength;
    private final MessageHeaders message;

    public IncomingEntityDetails(MessageHeaders messageHeaders, long j) {
        this.message = (MessageHeaders) Args.notNull(messageHeaders, AuthenticationConstants.BUNDLE_MESSAGE);
        this.contentLength = j;
    }

    public IncomingEntityDetails(MessageHeaders messageHeaders) {
        this(messageHeaders, -1L);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        Header firstHeader = this.message.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        Header firstHeader = this.message.getFirstHeader("Content-Encoding");
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.contentLength < 0;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        Header firstHeader = this.message.getFirstHeader("Trailer");
        if (firstHeader == null) {
            return Collections.emptySet();
        }
        return MessageSupport.parseTokens(firstHeader);
    }
}
