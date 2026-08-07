package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.pspdfkit.annotations.LineEndType;

/* JADX INFO: loaded from: classes3.dex */
public final class yn {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LineEndType.values().length];
            a = iArr;
            try {
                iArr[LineEndType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LineEndType.OPEN_ARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LineEndType.BUTT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LineEndType.SLASH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LineEndType.REVERSE_OPEN_ARROW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LineEndType.REVERSE_CLOSED_ARROW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LineEndType.CLOSED_ARROW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[LineEndType.SQUARE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[LineEndType.CIRCLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[LineEndType.DIAMOND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static Path a(LineEndType lineEndType, float f, float f2) {
        Path path = new Path();
        Matrix matrix = new Matrix();
        float f3 = f * 0.5f;
        float f4 = 0.5f * f2;
        switch (a.a[lineEndType.ordinal()]) {
            case 2:
                float f5 = -f2;
                path.moveTo(f5, f4);
                path.lineTo(f3, 0.0f);
                path.lineTo(f5, -f4);
                path.lineTo(f3, 0.0f);
                path.close();
                break;
            case 3:
                path.moveTo(0.0f, f4);
                path.lineTo(0.0f, -f4);
                break;
            case 4:
                path.moveTo(0.0f, -f4);
                path.lineTo(0.0f, f4);
                matrix.setRotate(30.0f);
                matrix.postTranslate(f3, 0.0f);
                path.transform(matrix);
                break;
            case 5:
                path.moveTo(f2, f4);
                path.lineTo(f3, 0.0f);
                path.lineTo(f2, -f4);
                path.lineTo(f3, 0.0f);
                path.close();
                break;
            case 6:
                path.moveTo(0.0f, 0.0f);
                path.lineTo(f2, f4);
                path.lineTo(f2, -f4);
                path.close();
                break;
            case 7:
                float f6 = -f2;
                path.moveTo(f6, f4);
                path.lineTo(f3, 0.0f);
                path.lineTo(f6, -f4);
                path.close();
                break;
            case 8:
                float f7 = -f4;
                RectF rectF = new RectF(-f2, f7, 0.0f, f7 + f2);
                path.moveTo(rectF.left, rectF.top);
                path.lineTo(rectF.right, rectF.top);
                path.lineTo(rectF.right, rectF.bottom);
                path.lineTo(rectF.left, rectF.bottom);
                path.close();
                break;
            case 9:
                float f8 = -f4;
                RectF rectF2 = new RectF(-f2, f8, 0.0f, f8 + f2);
                path.addRoundRect(rectF2, rectF2.width() / 2.0f, rectF2.height() / 2.0f, Path.Direction.CW);
                break;
            case 10:
                path.moveTo(-f2, 0.0f);
                float f9 = -f4;
                path.lineTo(f9, f9 + f2);
                path.lineTo(0.0f, 0.0f);
                path.lineTo(f9, f9);
                path.close();
                break;
        }
        if (lineEndType != LineEndType.REVERSE_OPEN_ARROW && lineEndType != LineEndType.REVERSE_CLOSED_ARROW) {
            return path;
        }
        matrix.setTranslate(-f2, 0.0f);
        path.transform(matrix);
        return path;
    }
}
