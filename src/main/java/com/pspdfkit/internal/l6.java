package com.pspdfkit.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class l6 {
    public static final boolean a(Context context) {
        context.getClass();
        return new hw(context).a("android.permission.RECORD_AUDIO") && context.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }
}
