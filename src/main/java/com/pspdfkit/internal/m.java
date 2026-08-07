package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final int a(TypedArray typedArray, Context context, int i, int i2, int i3) {
        int i4;
        typedArray.getClass();
        context.getClass();
        if (typedArray.hasValue(i)) {
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i, typedValue) && ((i4 = typedValue.type) == 0 || ((i4 >= 16 && i4 <= 31) || i4 == 3))) {
                return typedArray.getColor(i, 0);
            }
        }
        TypedValue typedValue2 = new TypedValue();
        return context.getTheme().resolveAttribute(i2, typedValue2, true) ? typedValue2.data : ContextCompat.getColor(context, i3);
    }

    public static final int a(TypedArray typedArray, Context context, int i, int i2) {
        int i3;
        context.getClass();
        if (typedArray.hasValue(i)) {
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i, typedValue) && ((i3 = typedValue.type) == 0 || ((i3 >= 16 && i3 <= 31) || i3 == 3))) {
                return typedArray.getColor(i, 0);
            }
        }
        return ContextCompat.getColor(context, i2);
    }
}
