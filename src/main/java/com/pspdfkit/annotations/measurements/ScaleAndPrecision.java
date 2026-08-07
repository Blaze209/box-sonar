package com.pspdfkit.annotations.measurements;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/annotations/measurements/ScaleAndPrecision;", "", "<init>", "()V", "scale", "Lcom/pspdfkit/annotations/measurements/Scale;", "getScale", "()Lcom/pspdfkit/annotations/measurements/Scale;", "precision", "Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;", "getPrecision", "()Lcom/pspdfkit/annotations/measurements/MeasurementPrecision;", "equals", "", "other", "hashCode", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ScaleAndPrecision {
    public static final int $stable = 0;

    public boolean equals(Object other) {
        if (!(other instanceof ScaleAndPrecision)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        ScaleAndPrecision scaleAndPrecision = (ScaleAndPrecision) other;
        return Intrinsics.areEqual(getScale(), scaleAndPrecision.getScale()) && getPrecision() == scaleAndPrecision.getPrecision();
    }

    public abstract MeasurementPrecision getPrecision();

    public abstract Scale getScale();

    public int hashCode() {
        return getPrecision().hashCode() + (getScale().hashCode() * 31);
    }
}
