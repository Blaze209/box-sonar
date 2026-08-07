package com.geniusscansdk.ocr;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpatialFloat.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/geniusscansdk/ocr/SpatialFloat;", "", "value", "", "boundingBox", "Lcom/geniusscansdk/ocr/RectangleF;", "documentSize", "Lcom/geniusscansdk/Size;", "<init>", "(DLcom/geniusscansdk/ocr/RectangleF;Lcom/geniusscansdk/Size;)V", "getValue", "()D", "getBoundingBox", "()Lcom/geniusscansdk/ocr/RectangleF;", "getDocumentSize", "()Lcom/geniusscansdk/Size;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SpatialFloat {
    private final RectangleF boundingBox;
    private final Size documentSize;
    private final double value;

    public static /* synthetic */ SpatialFloat copy$default(SpatialFloat spatialFloat, double d, RectangleF rectangleF, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            d = spatialFloat.value;
        }
        if ((i & 2) != 0) {
            rectangleF = spatialFloat.boundingBox;
        }
        if ((i & 4) != 0) {
            size = spatialFloat.documentSize;
        }
        return spatialFloat.copy(d, rectangleF, size);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RectangleF getBoundingBox() {
        return this.boundingBox;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Size getDocumentSize() {
        return this.documentSize;
    }

    public final SpatialFloat copy(double value, RectangleF boundingBox, Size documentSize) {
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        return new SpatialFloat(value, boundingBox, documentSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpatialFloat)) {
            return false;
        }
        SpatialFloat spatialFloat = (SpatialFloat) other;
        return Double.compare(this.value, spatialFloat.value) == 0 && Intrinsics.areEqual(this.boundingBox, spatialFloat.boundingBox) && Intrinsics.areEqual(this.documentSize, spatialFloat.documentSize);
    }

    public int hashCode() {
        int iHashCode = Double.hashCode(this.value) * 31;
        RectangleF rectangleF = this.boundingBox;
        return ((iHashCode + (rectangleF == null ? 0 : rectangleF.hashCode())) * 31) + this.documentSize.hashCode();
    }

    public String toString() {
        return "SpatialFloat(value=" + this.value + ", boundingBox=" + this.boundingBox + ", documentSize=" + this.documentSize + ")";
    }

    public SpatialFloat(double d, RectangleF rectangleF, Size documentSize) {
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        this.value = d;
        this.boundingBox = rectangleF;
        this.documentSize = documentSize;
    }

    public /* synthetic */ SpatialFloat(double d, RectangleF rectangleF, Size size, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, (i & 2) != 0 ? null : rectangleF, size);
    }

    public final double getValue() {
        return this.value;
    }

    public final RectangleF getBoundingBox() {
        return this.boundingBox;
    }

    public final Size getDocumentSize() {
        return this.documentSize;
    }
}
