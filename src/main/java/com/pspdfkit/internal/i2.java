package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i2<T> implements Comparator {
    public final /* synthetic */ PointF a;

    public i2(PointF pointF) {
        this.a = pointF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        RectF boundingBox = ((Annotation) t).getBoundingBox();
        PointF pointF = new PointF(boundingBox.centerX(), boundingBox.centerY());
        PointF pointF2 = this.a;
        double d = 2;
        Float fValueOf = Float.valueOf(((float) Math.pow(pointF2.x - pointF.x, d)) + ((float) Math.pow(pointF2.y - pointF.y, d)));
        RectF boundingBox2 = ((Annotation) t2).getBoundingBox();
        PointF pointF3 = new PointF(boundingBox2.centerX(), boundingBox2.centerY());
        PointF pointF4 = this.a;
        return ComparisonsKt.compareValues(fValueOf, Float.valueOf(((float) Math.pow(pointF4.x - pointF3.x, d)) + ((float) Math.pow(pointF4.y - pointF3.y, d))));
    }
}
