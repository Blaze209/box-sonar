package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class dz<T> implements Consumer {
    public static final dz<T> a = new dz<>();

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        ((Throwable) obj).getClass();
        PdfLog.e("Nutri.RenditionActExec", "Trying to execute RenditionAction not pointing to any Screen annotation.", new Object[0]);
    }
}
