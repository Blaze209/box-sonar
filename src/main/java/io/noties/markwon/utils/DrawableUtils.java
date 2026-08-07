package io.noties.markwon.utils;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class DrawableUtils {
    public static void intrinsicBounds(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private DrawableUtils() {
    }
}
