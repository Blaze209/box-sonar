package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.pspdfkit.ui.drawable.PdfDrawable;

/* JADX INFO: loaded from: classes3.dex */
public final class yv extends Drawable {
    public final PdfDrawable a;
    public final float b;
    public final Matrix c = new Matrix();

    public yv(PdfDrawable pdfDrawable, float f) {
        this.a = pdfDrawable;
        this.b = f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.c.reset();
        Matrix matrix = this.c;
        float f = this.b;
        matrix.setScale(f, -f);
        this.c.postTranslate(i, i4 - (i2 * 2));
        this.a.updatePdfToViewTransformation(this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
