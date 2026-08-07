package org.apache.hc.core5.io;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface ModalCloseable extends Closeable {
    void close(CloseMode closeMode);
}
