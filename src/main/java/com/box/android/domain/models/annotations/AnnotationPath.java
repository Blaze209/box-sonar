package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationPath;", "Lcom/box/android/domain/models/DomainModel;", "points", "", "Lcom/box/android/domain/models/annotations/AnnotationPoint;", "<init>", "(Ljava/util/List;)V", "getPoints", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationPath implements DomainModel {
    private final List<AnnotationPoint> points;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationPath copy$default(AnnotationPath annotationPath, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = annotationPath.points;
        }
        return annotationPath.copy(list);
    }

    public final List<AnnotationPoint> component1() {
        return this.points;
    }

    public final AnnotationPath copy(List<AnnotationPoint> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return new AnnotationPath(points);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnnotationPath) && Intrinsics.areEqual(this.points, ((AnnotationPath) other).points);
    }

    public int hashCode() {
        return this.points.hashCode();
    }

    public String toString() {
        return "AnnotationPath(points=" + this.points + ")";
    }

    public AnnotationPath(List<AnnotationPoint> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
    }

    public final List<AnnotationPoint> getPoints() {
        return this.points;
    }
}
