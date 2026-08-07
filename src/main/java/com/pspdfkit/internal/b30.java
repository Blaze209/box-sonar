package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;

/* JADX INFO: loaded from: classes3.dex */
public class b30<T> extends DisposableSingleObserver<T> {
    private final String LOG_TAG = "Nutri.SimpSingObserver";

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onError(Throwable th) {
        PdfLog.e("Nutri.SimpSingObserver", th, "Exception in observer!", new Object[0]);
    }

    @Override // io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(T t) {
    }
}
