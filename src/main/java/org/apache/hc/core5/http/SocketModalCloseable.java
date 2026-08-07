package org.apache.hc.core5.http;

import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface SocketModalCloseable extends ModalCloseable {
    Timeout getSocketTimeout();

    void setSocketTimeout(Timeout timeout);
}
