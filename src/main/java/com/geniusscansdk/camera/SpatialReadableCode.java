package com.geniusscansdk.camera;

import android.graphics.Rect;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.structureddata.ReadableCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpatialReadableCode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/geniusscansdk/camera/SpatialReadableCode;", "", "value", "", "type", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "bounds", "Landroid/graphics/Rect;", "sourceImageWidth", "", "sourceImageHeight", "<init>", "(Ljava/lang/String;Lcom/geniusscansdk/structureddata/ReadableCode$Type;Landroid/graphics/Rect;II)V", "getValue", "()Ljava/lang/String;", "getType", "()Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "getBounds", "()Landroid/graphics/Rect;", "getSourceImageWidth", "()I", "getSourceImageHeight", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SpatialReadableCode {
    private final Rect bounds;
    private final int sourceImageHeight;
    private final int sourceImageWidth;
    private final ReadableCode.Type type;
    private final String value;

    public static /* synthetic */ SpatialReadableCode copy$default(SpatialReadableCode spatialReadableCode, String str, ReadableCode.Type type, Rect rect, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = spatialReadableCode.value;
        }
        if ((i3 & 2) != 0) {
            type = spatialReadableCode.type;
        }
        if ((i3 & 4) != 0) {
            rect = spatialReadableCode.bounds;
        }
        if ((i3 & 8) != 0) {
            i = spatialReadableCode.sourceImageWidth;
        }
        if ((i3 & 16) != 0) {
            i2 = spatialReadableCode.sourceImageHeight;
        }
        int i4 = i2;
        Rect rect2 = rect;
        return spatialReadableCode.copy(str, type, rect2, i, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ReadableCode.Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Rect getBounds() {
        return this.bounds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSourceImageWidth() {
        return this.sourceImageWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSourceImageHeight() {
        return this.sourceImageHeight;
    }

    public final SpatialReadableCode copy(String value, ReadableCode.Type type, Rect bounds, int sourceImageWidth, int sourceImageHeight) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SpatialReadableCode(value, type, bounds, sourceImageWidth, sourceImageHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpatialReadableCode)) {
            return false;
        }
        SpatialReadableCode spatialReadableCode = (SpatialReadableCode) other;
        return Intrinsics.areEqual(this.value, spatialReadableCode.value) && this.type == spatialReadableCode.type && Intrinsics.areEqual(this.bounds, spatialReadableCode.bounds) && this.sourceImageWidth == spatialReadableCode.sourceImageWidth && this.sourceImageHeight == spatialReadableCode.sourceImageHeight;
    }

    public int hashCode() {
        int iHashCode = ((this.value.hashCode() * 31) + this.type.hashCode()) * 31;
        Rect rect = this.bounds;
        return ((((iHashCode + (rect == null ? 0 : rect.hashCode())) * 31) + Integer.hashCode(this.sourceImageWidth)) * 31) + Integer.hashCode(this.sourceImageHeight);
    }

    public String toString() {
        return "SpatialReadableCode(value=" + this.value + ", type=" + this.type + ", bounds=" + this.bounds + ", sourceImageWidth=" + this.sourceImageWidth + ", sourceImageHeight=" + this.sourceImageHeight + ")";
    }

    public SpatialReadableCode(String value, ReadableCode.Type type, Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.value = value;
        this.type = type;
        this.bounds = rect;
        this.sourceImageWidth = i;
        this.sourceImageHeight = i2;
    }

    public /* synthetic */ SpatialReadableCode(String str, ReadableCode.Type type, Rect rect, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, type, (i3 & 4) != 0 ? null : rect, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public final String getValue() {
        return this.value;
    }

    public final ReadableCode.Type getType() {
        return this.type;
    }

    public final Rect getBounds() {
        return this.bounds;
    }

    public final int getSourceImageWidth() {
        return this.sourceImageWidth;
    }

    public final int getSourceImageHeight() {
        return this.sourceImageHeight;
    }
}
