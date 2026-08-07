package org.apache.hc.core5.http.io;

import java.io.IOException;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface BHttpConnection extends HttpConnection {
    void flush() throws IOException;

    boolean isDataAvailable(Timeout timeout) throws IOException;

    boolean isStale() throws IOException;
}
