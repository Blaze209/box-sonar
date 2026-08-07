package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.LineEndType;

/* JADX INFO: loaded from: classes3.dex */
public final class i10 {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            a = iArr;
            try {
                iArr[AnnotationType.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnnotationType.POLYLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnnotationType.POLYGON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static RectF a(PointF pointF, PointF pointF2, LineEndType lineEndType, float f) {
        double dAtan2 = Math.atan2(pointF.y - pointF2.y, pointF2.x - pointF.x);
        Matrix matrix = new Matrix();
        matrix.setRotate((float) (3.141592653589793d - dAtan2));
        matrix.postTranslate(pointF.x, pointF.y);
        RectF rectF = new RectF();
        Path pathA = yn.a(lineEndType, f, pointF.equals(pointF2) ? 0.0f : (1.75f * f) + 12.0f);
        if (!pathA.isEmpty()) {
            pathA.transform(matrix);
            pathA.computeBounds(rectF, true);
            float f2 = -((float) ((Math.sqrt(2.0d) * ((double) f)) / 2.0d));
            rectF.inset(f2, f2);
        }
        return rectF;
    }

    public static float a(Annotation annotation) {
        AnnotationType type = annotation.getType();
        float borderWidth = annotation.getBorderWidth();
        float borderEffectIntensity = annotation.getBorderEffect() == BorderEffect.CLOUDY ? annotation.getBorderEffectIntensity() : 0.0f;
        if (borderEffectIntensity > 0.0f) {
            return ((borderEffectIntensity * 4.25f) + borderWidth) * 2.0f;
        }
        int i = a.a[type.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? Math.max(((float) Math.sqrt(2.0d)) * borderWidth, (borderWidth * 10.0f) / 2.0f) : borderWidth;
        }
        return (float) (Math.sqrt(2.0d) * ((double) borderWidth));
    }
}
