package com.swmansion.rnscreens.utils;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "resolveColorAttr", "", "context", "Landroid/content/Context;", "attr", "defaultColor", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ColorUtilsKt {
    private static final String TAG = "ColorUtils";

    public static /* synthetic */ int resolveColorAttr$default(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return resolveColorAttr(context, i, i2);
    }

    public static final int resolveColorAttr(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            Log.w(TAG, "[RNScreens] Failed to resolve color attribute. Falling back to " + i2 + ".");
            return i2;
        }
        return typedValue.data;
    }
}
