package com.pspdfkit.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class rg extends BitmapDrawable {
    public final long a;
    public Drawable b;
    public boolean c;
    public int d;

    public rg(Resources resources, Bitmap bitmap, Drawable drawable, boolean z) {
        super(resources, bitmap);
        this.d = 255;
        if (z) {
            this.b = drawable;
        }
        this.c = z;
        this.a = SystemClock.uptimeMillis();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (getBitmap() == null || getBitmap().isRecycled()) {
            return;
        }
        if (!this.c) {
            super.draw(canvas);
            return;
        }
        float fUptimeMillis = (SystemClock.uptimeMillis() - this.a) / 100.0f;
        if (fUptimeMillis >= 1.0f) {
            this.c = false;
            this.b = null;
            super.draw(canvas);
        } else {
            Drawable drawable = this.b;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            super.setAlpha((int) (fUptimeMillis * this.d));
            super.draw(canvas);
            super.setAlpha(this.d);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.d = i;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }
}
