package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;

/* JADX INFO: loaded from: classes3.dex */
public class u20 extends DisposableCompletableObserver {
    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public void onError(Throwable th) {
        PdfLog.e("Nutri.SimpCompObserver", th, "Exception in observer!", new Object[0]);
    }
}
