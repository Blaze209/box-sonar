package com.google.androidbrowserhelper.trusted;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes13.dex */
public class Utils {
    public static void setStatusBarColor(Activity activity, int i) {
        activity.getWindow().setStatusBarColor(i);
        if (shouldUseDarkIconsOnBackground(i)) {
            addSystemUiVisibilityFlag(activity, 8192);
        }
    }

    public static void setNavigationBarColor(Activity activity, int i) {
        activity.getWindow().setNavigationBarColor(i);
        if (shouldUseDarkIconsOnBackground(i)) {
            addSystemUiVisibilityFlag(activity, 16);
        }
    }

    private static void addSystemUiVisibilityFlag(Activity activity, int i) {
        View rootView = activity.getWindow().getDecorView().getRootView();
        rootView.setSystemUiVisibility(i | rootView.getSystemUiVisibility());
    }

    private static boolean shouldUseDarkIconsOnBackground(int i) {
        return Math.abs(1.05f / ((((luminanceOfColorComponent((float) Color.red(i)) * 0.2126f) + (luminanceOfColorComponent((float) Color.green(i)) * 0.7152f)) + (luminanceOfColorComponent((float) Color.blue(i)) * 0.0722f)) + 0.05f)) < 3.0f;
    }

    private static float luminanceOfColorComponent(float f) {
        float f2 = f / 255.0f;
        return f2 < 0.03928f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static Bitmap convertDrawableToBitmap(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable == null) {
            return null;
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableWrap.getIntrinsicWidth(), drawableWrap.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableWrap.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableWrap.draw(canvas);
        return bitmapCreateBitmap;
    }
}
