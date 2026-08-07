package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class mj<T> implements Consumer {
    public static final mj<T> a = new mj<>();

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        th.getClass();
        PdfLog.e("Nutri.HideActionExec", th, "Error while executing hide action.", new Object[0]);
    }
}
