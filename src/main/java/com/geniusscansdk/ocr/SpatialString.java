package com.geniusscansdk.ocr;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpatialString.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/geniusscansdk/ocr/SpatialString;", "", "string", "", "confidence", "", "boundingBox", "Lcom/geniusscansdk/ocr/RectangleF;", "documentSize", "Lcom/geniusscansdk/Size;", "<init>", "(Ljava/lang/String;DLcom/geniusscansdk/ocr/RectangleF;Lcom/geniusscansdk/Size;)V", "getString", "()Ljava/lang/String;", "getConfidence", "()D", "getBoundingBox", "()Lcom/geniusscansdk/ocr/RectangleF;", "getDocumentSize", "()Lcom/geniusscansdk/Size;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SpatialString {
    private final RectangleF boundingBox;
    private final double confidence;
    private final Size documentSize;
    private final String string;

    public static /* synthetic */ SpatialString copy$default(SpatialString spatialString, String str, double d, RectangleF rectangleF, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            str = spatialString.string;
        }
        if ((i & 2) != 0) {
            d = spatialString.confidence;
        }
        if ((i & 4) != 0) {
            rectangleF = spatialString.boundingBox;
        }
        if ((i & 8) != 0) {
            size = spatialString.documentSize;
        }
        return spatialString.copy(str, d, rectangleF, size);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getString() {
        return this.string;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RectangleF getBoundingBox() {
        return this.boundingBox;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Size getDocumentSize() {
        return this.documentSize;
    }

    public final SpatialString copy(String string, double confidence, RectangleF boundingBox, Size documentSize) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        return new SpatialString(string, confidence, boundingBox, documentSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpatialString)) {
            return false;
        }
        SpatialString spatialString = (SpatialString) other;
        return Intrinsics.areEqual(this.string, spatialString.string) && Double.compare(this.confidence, spatialString.confidence) == 0 && Intrinsics.areEqual(this.boundingBox, spatialString.boundingBox) && Intrinsics.areEqual(this.documentSize, spatialString.documentSize);
    }

    public int hashCode() {
        int iHashCode = ((this.string.hashCode() * 31) + Double.hashCode(this.confidence)) * 31;
        RectangleF rectangleF = this.boundingBox;
        return ((iHashCode + (rectangleF == null ? 0 : rectangleF.hashCode())) * 31) + this.documentSize.hashCode();
    }

    public String toString() {
        return "SpatialString(string=" + this.string + ", confidence=" + this.confidence + ", boundingBox=" + this.boundingBox + ", documentSize=" + this.documentSize + ")";
    }

    public SpatialString(String string, double d, RectangleF rectangleF, Size documentSize) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(documentSize, "documentSize");
        this.string = string;
        this.confidence = d;
        this.boundingBox = rectangleF;
        this.documentSize = documentSize;
    }

    public /* synthetic */ SpatialString(String str, double d, RectangleF rectangleF, Size size, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 1.0d : d, (i & 4) != 0 ? null : rectangleF, size);
    }

    public final String getString() {
        return this.string;
    }

    public final double getConfidence() {
        return this.confidence;
    }

    public final RectangleF getBoundingBox() {
        return this.boundingBox;
    }

    public final Size getDocumentSize() {
        return this.documentSize;
    }
}
