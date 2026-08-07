package com.pspdfkit.internal;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class ee<T> implements Consumer {
    public final /* synthetic */ CancellableContinuationImpl a;

    public ee(CancellableContinuationImpl cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Boolean bool = (Boolean) obj;
        bool.getClass();
        if (this.a.isActive()) {
            try {
                CancellableContinuationImpl cancellableContinuationImpl = this.a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m14780constructorimpl(bool));
            } catch (IllegalStateException unused) {
            }
        }
    }
}
