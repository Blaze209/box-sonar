package com.microsoft.intune.mam.client.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LightingColorFilter;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public class ThemeManagerBehaviorBase {
    public int getTextColor(Context context, int i) {
        return getColor(R.attr.colorForeground, context, i);
    }

    public int getAccentColor(Context context, int i) {
        return getColor(R.attr.colorAccent, context, i);
    }

    public int getBackgroundColor(Context context, int i) {
        return getColor(R.attr.colorBackground, context, i);
    }

    public void applyBackgroundColor(Window window, int i) {
        window.getDecorView().getBackground().setColorFilter(new LightingColorFilter(0, i));
    }

    private int getColor(int i, Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, new int[]{i});
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }
}
