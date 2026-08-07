package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
abstract class InternalChannel implements ModalCloseable {
    abstract long getLastEventTime();

    abstract Timeout getTimeout();

    abstract void onException(Exception exc);

    abstract void onIOEvent(int i) throws IOException;

    abstract void onTimeout(Timeout timeout) throws IOException;

    InternalChannel() {
    }

    final void handleIOEvent(int i) {
        try {
            onIOEvent(i);
        } catch (CancelledKeyException unused) {
            close(CloseMode.GRACEFUL);
        } catch (Exception e) {
            onException(e);
            close(CloseMode.GRACEFUL);
        }
    }

    final boolean checkTimeout(long j) {
        Timeout timeout = getTimeout();
        if (timeout.isDisabled()) {
            return true;
        }
        if (j <= getLastEventTime() + timeout.toMilliseconds()) {
            return true;
        }
        try {
            onTimeout(timeout);
            return false;
        } catch (CancelledKeyException unused) {
            close(CloseMode.GRACEFUL);
            return false;
        } catch (Exception e) {
            onException(e);
            close(CloseMode.GRACEFUL);
            return false;
        }
    }
}
