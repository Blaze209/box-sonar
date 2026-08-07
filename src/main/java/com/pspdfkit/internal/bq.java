package com.pspdfkit.internal;

import com.pspdfkit.annotations.AnnotationType;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class bq {
    public static final EnumSet<AnnotationType> a = EnumSet.of(AnnotationType.LINE, AnnotationType.POLYLINE, AnnotationType.POLYGON, AnnotationType.CIRCLE, AnnotationType.SQUARE);
    public static final DecimalFormat b;

    static {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        b = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    }
}
