package com.pspdfkit.internal;

import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;

/* JADX INFO: loaded from: classes3.dex */
public final class p10 {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
            int[] iArr2 = new int[AnnotationTool.values().length];
            try {
                iArr2[AnnotationTool.MEASUREMENT_DISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_PERIMETER.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_AREA_RECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_AREA_ELLIPSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[AnnotationTool.MEASUREMENT_AREA_POLYGON.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            b = iArr2;
        }
    }

    public static final boolean a(AnnotationType annotationType) {
        annotationType.getClass();
        int i = a.a[annotationType.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
