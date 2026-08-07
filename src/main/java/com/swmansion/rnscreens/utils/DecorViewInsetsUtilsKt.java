package com.swmansion.rnscreens.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecorViewInsetsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"getDecorViewTopInset", "", "decorView", "Landroid/view/View;", "getTopInset", "insetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "isSoftKeyboardVisibleOrNull", "", "(Landroid/view/View;)Ljava/lang/Boolean;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DecorViewInsetsUtilsKt {
    public static final int getDecorViewTopInset(View decorView) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(decorView);
        if (rootWindowInsets == null) {
            return 0;
        }
        return getTopInset(rootWindowInsets);
    }

    private static final int getTopInset(WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()).top;
    }

    public static final Boolean isSoftKeyboardVisibleOrNull(View decorView) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(decorView);
        if (rootWindowInsets == null) {
            return null;
        }
        return Boolean.valueOf(rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()));
    }
}
