package org.apache.hc.core5.pool;

import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;

/* JADX INFO: loaded from: classes5.dex */
public interface DisposalCallback<T extends ModalCloseable> {
    void execute(T t, CloseMode closeMode);
}
