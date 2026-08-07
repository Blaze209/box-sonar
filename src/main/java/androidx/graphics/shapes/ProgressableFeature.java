package androidx.graphics.shapes;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureMapping.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/graphics/shapes/ProgressableFeature;", "", "progress", "", "feature", "Landroidx/graphics/shapes/Feature;", "<init>", "(FLandroidx/graphics/shapes/Feature;)V", "getProgress", "()F", "getFeature", "()Landroidx/graphics/shapes/Feature;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ProgressableFeature {
    private final Feature feature;
    private final float progress;

    public static /* synthetic */ ProgressableFeature copy$default(ProgressableFeature progressableFeature, float f, Feature feature, int i, Object obj) {
        if ((i & 1) != 0) {
            f = progressableFeature.progress;
        }
        if ((i & 2) != 0) {
            feature = progressableFeature.feature;
        }
        return progressableFeature.copy(f, feature);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Feature getFeature() {
        return this.feature;
    }

    public final ProgressableFeature copy(float progress, Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return new ProgressableFeature(progress, feature);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgressableFeature)) {
            return false;
        }
        ProgressableFeature progressableFeature = (ProgressableFeature) other;
        return Float.compare(this.progress, progressableFeature.progress) == 0 && Intrinsics.areEqual(this.feature, progressableFeature.feature);
    }

    public int hashCode() {
        return (Float.hashCode(this.progress) * 31) + this.feature.hashCode();
    }

    public String toString() {
        return "ProgressableFeature(progress=" + this.progress + ", feature=" + this.feature + ')';
    }

    public ProgressableFeature(float f, Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        this.progress = f;
        this.feature = feature;
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final float getProgress() {
        return this.progress;
    }
}
