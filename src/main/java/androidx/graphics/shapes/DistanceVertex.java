package androidx.graphics.shapes;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureMapping.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/graphics/shapes/DistanceVertex;", "", "distance", "", "f1", "Landroidx/graphics/shapes/ProgressableFeature;", "f2", "<init>", "(FLandroidx/graphics/shapes/ProgressableFeature;Landroidx/graphics/shapes/ProgressableFeature;)V", "getDistance", "()F", "getF1", "()Landroidx/graphics/shapes/ProgressableFeature;", "getF2", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DistanceVertex {
    private final float distance;
    private final ProgressableFeature f1;
    private final ProgressableFeature f2;

    public static /* synthetic */ DistanceVertex copy$default(DistanceVertex distanceVertex, float f, ProgressableFeature progressableFeature, ProgressableFeature progressableFeature2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = distanceVertex.distance;
        }
        if ((i & 2) != 0) {
            progressableFeature = distanceVertex.f1;
        }
        if ((i & 4) != 0) {
            progressableFeature2 = distanceVertex.f2;
        }
        return distanceVertex.copy(f, progressableFeature, progressableFeature2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDistance() {
        return this.distance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ProgressableFeature getF1() {
        return this.f1;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ProgressableFeature getF2() {
        return this.f2;
    }

    public final DistanceVertex copy(float distance, ProgressableFeature f1, ProgressableFeature f2) {
        Intrinsics.checkNotNullParameter(f1, "f1");
        Intrinsics.checkNotNullParameter(f2, "f2");
        return new DistanceVertex(distance, f1, f2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DistanceVertex)) {
            return false;
        }
        DistanceVertex distanceVertex = (DistanceVertex) other;
        return Float.compare(this.distance, distanceVertex.distance) == 0 && Intrinsics.areEqual(this.f1, distanceVertex.f1) && Intrinsics.areEqual(this.f2, distanceVertex.f2);
    }

    public int hashCode() {
        return (((Float.hashCode(this.distance) * 31) + this.f1.hashCode()) * 31) + this.f2.hashCode();
    }

    public String toString() {
        return "DistanceVertex(distance=" + this.distance + ", f1=" + this.f1 + ", f2=" + this.f2 + ')';
    }

    public DistanceVertex(float f, ProgressableFeature f1, ProgressableFeature f2) {
        Intrinsics.checkNotNullParameter(f1, "f1");
        Intrinsics.checkNotNullParameter(f2, "f2");
        this.distance = f;
        this.f1 = f1;
        this.f2 = f2;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final ProgressableFeature getF1() {
        return this.f1;
    }

    public final ProgressableFeature getF2() {
        return this.f2;
    }
}
