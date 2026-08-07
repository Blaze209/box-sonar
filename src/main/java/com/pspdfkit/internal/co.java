package com.pspdfkit.internal;

import android.graphics.RectF;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.exceptions.NutrientException;

/* JADX INFO: loaded from: classes3.dex */
public final class co extends q1 {
    public static boolean g;
    public static final Paint h = AndroidPaint_androidKt.Paint();
    public static final Paint i = AndroidPaint_androidKt.Paint();
    public static final Paint j = AndroidPaint_androidKt.Paint();
    public static final Paint k = AndroidPaint_androidKt.Paint();
    public final ActionResolver c;
    public Paint d;
    public Paint e;
    public boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(LinkAnnotation linkAnnotation, ActionResolver actionResolver) {
        super(linkAnnotation);
        linkAnnotation.getClass();
        this.c = actionResolver;
        Paint paint = h;
        this.d = paint;
        this.e = paint;
    }

    @Override // com.pspdfkit.internal.q1
    public final void a(DrawContext drawContext) {
        drawContext.getClass();
        if (!g) {
            w4 w4Var = ca.a;
            if (w4Var == null) {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getAnnotationThemeConfiguration()");
            }
            g = true;
            Paint paint = h;
            PaintingStyle.Companion companion = PaintingStyle.INSTANCE;
            paint.mo6694setStylek9PVt8s(companion.m7097getFillTiuSbCo());
            BlendMode blendMode = BlendMode.DARKEN;
            gf.a(paint, blendMode);
            paint.mo6690setColor8_81llA(ColorKt.Color(w4Var.j));
            Paint paint2 = i;
            paint2.mo6694setStylek9PVt8s(companion.m7098getStrokeTiuSbCo());
            gf.a(paint2, blendMode);
            paint2.mo6690setColor8_81llA(ColorKt.Color(w4Var.k));
            Paint paint3 = j;
            paint3.mo6694setStylek9PVt8s(companion.m7097getFillTiuSbCo());
            gf.a(paint3, blendMode);
            paint3.mo6690setColor8_81llA(ColorKt.Color(w4Var.l));
            Paint paint4 = k;
            paint4.mo6694setStylek9PVt8s(companion.m7098getStrokeTiuSbCo());
            gf.a(paint4, blendMode);
            paint4.mo6690setColor8_81llA(ColorKt.Color(w4Var.m));
            this.d = paint;
            this.e = paint2;
        }
        float density = drawContext.getDensity().getDensity() * 2;
        RectF screenRect = this.b.getScreenRect();
        drawContext.getCanvas().drawRoundRect(screenRect.left, screenRect.top, screenRect.right, screenRect.bottom, density, density, this.d);
        drawContext.getCanvas().drawRoundRect(screenRect.left, screenRect.top, screenRect.right, screenRect.bottom, density, density, this.e);
    }
}
