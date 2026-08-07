package com.pspdfkit.internal;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class un {
    public static float a(Context context, int i, float f) {
        return TypedValue.applyDimension(i, f, context.getResources().getDisplayMetrics());
    }
}
