package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class b50 {
    public final uz a;
    public final View b;
    public float i;
    public float j;
    public float k;
    public float l;
    public final float m;
    public final float n;
    public final float o;
    public Bitmap r;
    public int c = 0;
    public float d = 1.25f;
    public final Path e = new Path();
    public final RectF f = new RectF();
    public final Matrix g = new Matrix();
    public final int[] h = new int[2];
    public boolean p = false;
    public final Paint q = new Paint(2);

    public b50(View view) {
        if (view == null) {
            throw new NullPointerException("View to magnify may not be null.");
        }
        this.b = view;
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.internal.b50$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.a(view2, windowInsetsCompat);
            }
        });
        Context context = view.getContext();
        this.a = new uz(view);
        this.m = a80.a(context, 100) / 2.0f;
        this.n = ((int) un.a(context, 1, 48)) / 2.0f;
        this.k = (int) un.a(context, 1, 0);
        this.l = (int) un.a(context, 1, -42);
        this.o = (int) un.a(context, 1, 38);
    }

    public final /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        if (displayCutout != null) {
            this.c = displayCutout.getSafeInsetTop();
        }
        return windowInsetsCompat.consumeStableInsets();
    }

    public final void a(float f, float f2) {
        View rootView = this.b.getRootView();
        boolean z = this.p;
        rootView.setDrawingCacheEnabled(true);
        rootView.setDrawingCacheBackgroundColor(-1);
        rootView.buildDrawingCache(true);
        this.p = false;
        Bitmap drawingCache = rootView.getDrawingCache(false);
        this.p = z;
        Bitmap bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
        rootView.setDrawingCacheEnabled(false);
        this.r = bitmapCreateBitmap;
        this.p = true;
        this.i = (int) f;
        this.j = (int) f2;
        this.b.invalidate();
    }
}
