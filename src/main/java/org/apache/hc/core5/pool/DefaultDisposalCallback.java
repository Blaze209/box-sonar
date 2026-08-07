package org.apache.hc.core5.pool;

import org.apache.hc.core5.http.SocketModalCloseable;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultDisposalCallback<T extends SocketModalCloseable> implements DisposalCallback<T> {
    private static final Timeout DEFAULT_CLOSE_TIMEOUT = Timeout.ofSeconds(1L);

    @Override // org.apache.hc.core5.pool.DisposalCallback
    public void execute(SocketModalCloseable socketModalCloseable, CloseMode closeMode) {
        Timeout socketTimeout = socketModalCloseable.getSocketTimeout();
        if (socketTimeout == null || socketTimeout.compareTo(TimeValue.ZERO_MILLISECONDS) <= 0 || socketTimeout.compareTo((TimeValue) DEFAULT_CLOSE_TIMEOUT) > 0) {
            socketModalCloseable.setSocketTimeout(DEFAULT_CLOSE_TIMEOUT);
        }
        socketModalCloseable.close(closeMode);
    }
}
