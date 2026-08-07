package com.pspdfkit.internal.jni;

import android.graphics.PointF;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSnapPoint {
    final PointF mPoint;
    final EnumSet<NativeSnapPointType> mType;

    public NativeSnapPoint(PointF pointF, EnumSet<NativeSnapPointType> enumSet) {
        this.mPoint = pointF;
        this.mType = enumSet;
    }

    public PointF getPoint() {
        return this.mPoint;
    }

    public EnumSet<NativeSnapPointType> getType() {
        return this.mType;
    }

    public String toString() {
        return "NativeSnapPoint{mPoint=" + this.mPoint + ",mType=" + this.mType + "}";
    }
}
