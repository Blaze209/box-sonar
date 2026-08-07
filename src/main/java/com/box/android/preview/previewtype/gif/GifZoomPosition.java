package com.box.android.preview.previewtype.gif;

import androidx.compose.ui.geometry.Offset;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifZoomPosition.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifZoomPosition;", "", "scale", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(FJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScale", "()F", "getOffset-F1C5BW0", "()J", "J", "component1", "component2", "component2-F1C5BW0", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-Uv8p0NA", "(FJ)Lcom/box/android/preview/previewtype/gif/GifZoomPosition;", "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GifZoomPosition {
    public static final int $stable = 0;
    private final long offset;
    private final float scale;

    public /* synthetic */ GifZoomPosition(float f, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, j);
    }

    /* JADX INFO: renamed from: copy-Uv8p0NA$default, reason: not valid java name */
    public static /* synthetic */ GifZoomPosition m12940copyUv8p0NA$default(GifZoomPosition gifZoomPosition, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            f = gifZoomPosition.scale;
        }
        if ((i & 2) != 0) {
            j = gifZoomPosition.offset;
        }
        return gifZoomPosition.m12942copyUv8p0NA(f, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: copy-Uv8p0NA, reason: not valid java name */
    public final GifZoomPosition m12942copyUv8p0NA(float scale, long offset) {
        return new GifZoomPosition(scale, offset, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifZoomPosition)) {
            return false;
        }
        GifZoomPosition gifZoomPosition = (GifZoomPosition) other;
        return Float.compare(this.scale, gifZoomPosition.scale) == 0 && Offset.m6566equalsimpl0(this.offset, gifZoomPosition.offset);
    }

    public int hashCode() {
        return (Float.hashCode(this.scale) * 31) + Offset.m6571hashCodeimpl(this.offset);
    }

    public String toString() {
        return "GifZoomPosition(scale=" + this.scale + ", offset=" + Offset.m6577toStringimpl(this.offset) + ")";
    }

    private GifZoomPosition(float f, long j) {
        this.scale = f;
        this.offset = j;
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m12943getOffsetF1C5BW0() {
        return this.offset;
    }

    public final float getScale() {
        return this.scale;
    }
}
