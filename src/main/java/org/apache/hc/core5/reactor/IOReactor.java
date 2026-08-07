package org.apache.hc.core5.reactor;

import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.TimeValue;

/* JADX INFO: loaded from: classes5.dex */
public interface IOReactor extends ModalCloseable {
    void awaitShutdown(TimeValue timeValue) throws InterruptedException;

    @Override // org.apache.hc.core5.io.ModalCloseable
    void close(CloseMode closeMode);

    IOReactorStatus getStatus();

    void initiateShutdown();
}
