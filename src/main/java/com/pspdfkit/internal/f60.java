package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class f60 {
    public static int a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    public static int b(Context context, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int a(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return typedValue.data;
            }
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                return ContextCompat.getColor(context, i4);
            }
        }
        return ContextCompat.getColor(context, i2);
    }
}
