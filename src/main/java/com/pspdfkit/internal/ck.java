package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class ck<T> implements Consumer {
    public static final ck<T> a = new ck<>();

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        th.getClass();
        PdfLog.e("Nutri.ImageESignLayout", th, "Can't import signature image: Bitmap decoding failed.", new Object[0]);
    }
}
