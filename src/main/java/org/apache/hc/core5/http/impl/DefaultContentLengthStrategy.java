package org.apache.hc.core5.http.impl;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.NotImplementedException;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultContentLengthStrategy implements ContentLengthStrategy {
    public static final DefaultContentLengthStrategy INSTANCE = new DefaultContentLengthStrategy();

    enum Coding {
        UNKNOWN,
        CHUNK
    }

    @Override // org.apache.hc.core5.http.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            final AtomicReference atomicReference = new AtomicReference();
            MessageSupport.parseTokens(httpMessage, "Transfer-Encoding", (Consumer<String>) new Consumer() { // from class: org.apache.hc.core5.http.impl.DefaultContentLengthStrategy$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    DefaultContentLengthStrategy.lambda$determineLength$0(atomicReference, (String) obj);
                }
            });
            if (atomicReference.get() == Coding.CHUNK) {
                return -1L;
            }
            throw new NotImplementedException("Unsupported transfer encoding: " + firstHeader.getValue());
        }
        if (httpMessage.countHeaders("Content-Length") > 1) {
            throw new ProtocolException("Multiple Content-Length headers");
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
        if (firstHeader2 == null) {
            return -9223372036854775807L;
        }
        String value = firstHeader2.getValue();
        try {
            long j = Long.parseLong(value);
            if (j >= 0) {
                return j;
            }
            throw new ProtocolException("Negative content length: " + value);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Invalid content length: " + value);
        }
    }

    static /* synthetic */ void lambda$determineLength$0(AtomicReference atomicReference, String str) {
        if (TextUtils.isBlank(str)) {
            return;
        }
        if (str.equalsIgnoreCase("chunked")) {
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, Coding.CHUNK)) {
                return;
            }
            atomicReference.set(Coding.UNKNOWN);
            return;
        }
        atomicReference.set(Coding.UNKNOWN);
    }
}
