package org.apache.hc.core5.pool;

import org.apache.hc.core5.io.ModalCloseable;

/* JADX INFO: loaded from: classes5.dex */
public interface ManagedConnPool<T, C extends ModalCloseable> extends ConnPool<T, C>, ConnPoolControl<T>, ModalCloseable {
}
