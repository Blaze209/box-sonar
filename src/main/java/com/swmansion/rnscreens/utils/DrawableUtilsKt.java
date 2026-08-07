package com.swmansion.rnscreens.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawableUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "resolveDrawableAttr", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "attrId", "", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DrawableUtilsKt {
    private static final String TAG = "DrawableUtils";

    public static final Drawable resolveDrawableAttr(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true) || typedValue.resourceId == 0) {
            Log.w(TAG, "[RNScreens] Failed to resolve drawable attribute.");
            return null;
        }
        return AppCompatResources.getDrawable(context, typedValue.resourceId);
    }
}
