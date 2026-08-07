package com.pspdfkit.internal;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.exceptions.NutrientException;

/* JADX INFO: loaded from: classes3.dex */
public final class ef {
    public final float a;
    public final float b;
    public final Paint c;
    public final Path d = new Path();

    public ef(PdfConfiguration pdfConfiguration) {
        w4 w4Var = ca.a;
        if (w4Var == null) {
            throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getAnnotationThemeConfiguration()");
        }
        this.a = pdfConfiguration.getResizeGuideSnapAllowance();
        this.b = w4Var.i;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(w4Var.h);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(w4Var.g);
        int size = pdfConfiguration.getGuideLineIntervals().size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = pdfConfiguration.getGuideLineIntervals().get(i).floatValue();
        }
        this.c.setPathEffect(new DashPathEffect(fArr, 0.0f));
    }
}
