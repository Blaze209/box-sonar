package com.pspdfkit.internal;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class tr {
    public static int a(Activity activity) {
        String str;
        int dimensionPixelSize;
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        float fMin = 0.0f;
        if (rootWindowInsets != null) {
            dimensionPixelSize = rootWindowInsets.getMandatorySystemGestureInsets().bottom > 0 ? 1 : 0;
            WindowManager windowManager = (WindowManager) activity.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                float f = displayMetrics.widthPixels;
                float f2 = displayMetrics.density;
                fMin = Math.min(f / f2, displayMetrics.heightPixels / f2);
            }
            return (fMin < 600.0f && activity.getResources().getConfiguration().orientation == 2 && dimensionPixelSize == 0) ? Math.max(rootWindowInsets.getStableInsetLeft(), rootWindowInsets.getStableInsetRight()) : rootWindowInsets.getStableInsetBottom();
        }
        if (activity.getResources().getConfiguration().orientation == 2) {
            WindowManager windowManager2 = (WindowManager) activity.getSystemService("window");
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (windowManager2 != null) {
                windowManager2.getDefaultDisplay().getRealMetrics(displayMetrics2);
                float f3 = displayMetrics2.widthPixels;
                float f4 = displayMetrics2.density;
                fMin = Math.min(f3 / f4, displayMetrics2.heightPixels / f4);
            }
            str = fMin >= 600.0f ? "navigation_bar_height_landscape" : "navigation_bar_width";
        } else {
            str = "navigation_bar_height";
        }
        int identifier = activity.getResources().getIdentifier(str, "dimen", "android");
        dimensionPixelSize = identifier != 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize == 0 ? activity.getResources().getDimensionPixelSize(R.dimen.pspdf__navigation_bar_height) : dimensionPixelSize;
    }
}
