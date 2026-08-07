package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "getSystemDrawableResource", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "iconName", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SystemDrawableKt {
    private static final String TAG = "SystemDrawable";

    public static final Drawable getSystemDrawableResource(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        if (identifier > 0) {
            return AppCompatResources.getDrawable(context, identifier);
        }
        int identifier2 = context.getResources().getIdentifier(str, "drawable", "android");
        if (identifier2 > 0) {
            return AppCompatResources.getDrawable(context, identifier2);
        }
        Log.w(TAG, "[RNScreens] Unable to resolve drawable resource with the name " + str);
        return null;
    }
}
