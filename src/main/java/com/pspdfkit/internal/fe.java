package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class fe<T> implements Consumer {
    public final /* synthetic */ CancellableContinuationImpl a;

    public fe(CancellableContinuationImpl cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        th.getClass();
        if (!this.a.isActive()) {
            PdfLog.e("Nutri.DocumentSaver", th, "Save failed after cancellation.", new Object[0]);
            return;
        }
        try {
            CancellableContinuationImpl cancellableContinuationImpl = this.a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(th)));
        } catch (IllegalStateException unused) {
            PdfLog.e("Nutri.DocumentSaver", th, "Save failed after cancellation.", new Object[0]);
        }
    }
}
