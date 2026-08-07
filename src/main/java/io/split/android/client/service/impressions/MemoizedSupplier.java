package io.split.android.client.service.impressions;

import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes4.dex */
class MemoizedSupplier<T> implements Supplier<T> {
    private final Supplier<T> mDelegate;
    private boolean mIsComputed = false;
    private T mValue;

    public MemoizedSupplier(Supplier<T> delegate) {
        this.mDelegate = delegate;
    }

    @Override // androidx.core.util.Supplier
    public synchronized T get() {
        if (!this.mIsComputed) {
            this.mValue = this.mDelegate.get();
            this.mIsComputed = true;
        }
        return this.mValue;
    }
}
