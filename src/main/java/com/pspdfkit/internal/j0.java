package com.pspdfkit.internal;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements am {
    public final Context a;

    public j0(Context context) {
        context.getClass();
        this.a = context;
    }

    public final boolean a() {
        return this.a.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public final s8 a(Function0<? extends Uri> function0) {
        function0.getClass();
        if (!this.a.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            return s8.b.a;
        }
        Uri uriInvoke = function0.invoke();
        return uriInvoke == null ? s8.a.a : new s8.c(uriInvoke);
    }
}
