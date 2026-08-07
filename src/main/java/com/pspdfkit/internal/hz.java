package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class hz<T> implements Consumer {
    public static final hz<T> a = new hz<>();

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        th.getClass();
        PdfLog.e("Nutri.ResetFormActExec", th, "Error while resetting form fields.", new Object[0]);
    }
}
