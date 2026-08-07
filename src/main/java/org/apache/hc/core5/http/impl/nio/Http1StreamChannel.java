package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.nio.ContentEncoder;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
interface Http1StreamChannel<OutgoingMessage extends HttpMessage> extends ContentEncoder {
    boolean abortGracefully() throws IOException;

    void activate() throws HttpException, IOException;

    void close();

    Timeout getSocketTimeout();

    void requestOutput();

    void setSocketTimeout(Timeout timeout);

    void submit(OutgoingMessage outgoingmessage, boolean z, FlushMode flushMode) throws HttpException, IOException;

    void suspendOutput() throws IOException;
}
