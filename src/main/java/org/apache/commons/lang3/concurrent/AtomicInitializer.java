package org.apache.commons.lang3.concurrent;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    protected abstract T initialize() throws ConcurrentException;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T tInitialize = this.reference.get();
        if (tInitialize == null) {
            tInitialize = initialize();
            if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.reference, null, tInitialize)) {
                return this.reference.get();
            }
        }
        return tInitialize;
    }
}
