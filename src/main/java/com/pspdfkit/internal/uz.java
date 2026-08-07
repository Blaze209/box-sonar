package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class uz {
    public final View a;
    public RenderScript b;
    public ScriptIntrinsicBlur c;
    public final Bitmap d;
    public Bitmap e;
    public final float f;

    public uz(View view) {
        view.getClass();
        this.a = view;
        Context context = view.getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        float fApplyDimension = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        float fApplyDimension2 = TypedValue.applyDimension(1, 100.0f, displayMetrics2);
        DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
        displayMetrics3.getClass();
        float fApplyDimension3 = TypedValue.applyDimension(1, 48.0f, displayMetrics3);
        DisplayMetrics displayMetrics4 = context.getResources().getDisplayMetrics();
        displayMetrics4.getClass();
        float fApplyDimension4 = TypedValue.applyDimension(1, 38.0f, displayMetrics4);
        DisplayMetrics displayMetrics5 = context.getResources().getDisplayMetrics();
        displayMetrics5.getClass();
        float fApplyDimension5 = (fApplyDimension / TypedValue.applyDimension(1, 24.0f, displayMetrics5)) * 25.0f;
        this.f = fApplyDimension5;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_IN));
        paint.setAlpha(102);
        new RectF(0.0f, 0.0f, fApplyDimension2, fApplyDimension3);
        float f = ((int) fApplyDimension5) * 2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (fApplyDimension2 + f), (int) (f + fApplyDimension3), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.getClass();
        this.d = bitmapCreateBitmap;
        if (bitmapCreateBitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurredBitmap");
            bitmapCreateBitmap = null;
        }
        new Canvas(bitmapCreateBitmap).drawRoundRect(new RectF(fApplyDimension5, fApplyDimension5, fApplyDimension2 + fApplyDimension5, fApplyDimension3 + fApplyDimension5), fApplyDimension4, fApplyDimension4, paint);
    }

    public final void a(Canvas canvas, float f, float f2) {
        canvas.getClass();
        if (this.e == null) {
            Bitmap bitmap = this.d;
            if (bitmap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurredBitmap");
                bitmap = null;
            }
            if (this.f != 0.0f) {
                RenderScript renderScript = this.b;
                if (renderScript == null) {
                    bitmap = null;
                } else {
                    Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap);
                    Allocation allocationCreateTyped = Allocation.createTyped(this.b, allocationCreateFromBitmap.getType());
                    ScriptIntrinsicBlur scriptIntrinsicBlur = this.c;
                    if (scriptIntrinsicBlur != null) {
                        scriptIntrinsicBlur.setRadius(this.f);
                    }
                    ScriptIntrinsicBlur scriptIntrinsicBlur2 = this.c;
                    if (scriptIntrinsicBlur2 != null) {
                        scriptIntrinsicBlur2.setInput(allocationCreateFromBitmap);
                    }
                    ScriptIntrinsicBlur scriptIntrinsicBlur3 = this.c;
                    if (scriptIntrinsicBlur3 != null) {
                        scriptIntrinsicBlur3.forEach(allocationCreateTyped);
                    }
                    allocationCreateTyped.copyTo(bitmap);
                    allocationCreateFromBitmap.destroy();
                    allocationCreateTyped.destroy();
                }
            }
            this.e = bitmap;
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurredBitmap");
            bitmap2 = null;
        }
        float f3 = this.f;
        canvas.drawBitmap(bitmap2, f - f3, f2 - (f3 / 2.0f), (Paint) null);
    }

    public final void b() {
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.c;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScript = this.b;
        if (renderScript != null) {
            renderScript.destroy();
        }
    }

    public final void a() {
        RenderScript renderScriptCreate = RenderScript.create(this.a.getContext());
        this.b = renderScriptCreate;
        this.c = ScriptIntrinsicBlur.create(this.b, Element.U8_4(renderScriptCreate));
    }
}
