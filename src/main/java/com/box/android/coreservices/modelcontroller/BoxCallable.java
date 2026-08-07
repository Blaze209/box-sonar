package com.box.android.coreservices.modelcontroller;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxCallable<E> implements Callable<E> {
    private long requestId;

    public void onCancel(boolean z) {
    }

    public void setRequestId(long j) {
        this.requestId = j;
    }

    public long getRequestId() {
        return this.requestId;
    }
}
