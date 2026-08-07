package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Size;
import androidx.media3.extractor.ts.PsExtractor;

/* JADX INFO: loaded from: classes3.dex */
public final class vm extends Drawable {
    public final Bitmap a;
    public final Paint b = new Paint(1);

    public vm(Context context, Drawable drawable, int i) {
        Bitmap bitmapA = ff.a(drawable);
        int width = bitmapA.getWidth();
        int height = bitmapA.getHeight();
        int iA = (a80.a(context, 8) * 2) + width;
        float f = iA / 2.0f;
        setBounds(0, 0, iA, iA);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, iA, Bitmap.Config.ARGB_8888);
        this.a = bitmapCreateBitmap;
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmapA, (iA - width) / 2.0f, (iA - height) / 2.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.argb(PsExtractor.VIDEO_STREAM_MASK, Color.red(i), Color.green(i), Color.blue(i)));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawCircle(f, f, f, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawBitmap(this.a, 0.0f, 0.0f, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.a.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.a.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public vm(Context context, Drawable drawable, int i, Size size, Path path, Paint paint, boolean z) {
        Bitmap bitmapA = ff.a(drawable);
        int width = bitmapA.getWidth();
        int height = bitmapA.getHeight();
        int width2 = size.getWidth();
        int height2 = size.getHeight();
        setBounds(0, 0, width2, height2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        this.a = bitmapCreateBitmap;
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int iA = a80.a(context, 12);
        if (!z) {
            Paint paint2 = new Paint();
            paint2.setColor(Color.argb(PsExtractor.VIDEO_STREAM_MASK, Color.red(i), Color.green(i), Color.blue(i)));
            float f = iA;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), f, f, paint2);
        }
        canvas.drawBitmap(bitmapA, (size.getWidth() - width) / 2.0f, (size.getHeight() - height) / 2.0f, (Paint) null);
        if (path != null) {
            canvas.drawPath(path, paint);
        }
        if (z) {
            RectF rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
            float f2 = iA;
            Paint paint3 = new Paint();
            paint3.setAntiAlias(true);
            paint3.setColor(Color.argb(PsExtractor.VIDEO_STREAM_MASK, Color.red(i), Color.green(i), Color.blue(i)));
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            canvas.drawRoundRect(rectF, f2, f2, paint3);
        }
    }
}
