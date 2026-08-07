package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class rz<T> implements Consumer {
    public static final rz<T> a = new rz<>();

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        ((Throwable) obj).getClass();
        PdfLog.e("Nutri.RichMedExecActExe", "Trying to execute RichMediaExecuteAction not pointing to any RichMedia annotation.", new Object[0]);
    }
}
