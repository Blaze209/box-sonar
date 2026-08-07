package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationPoint;", "Lcom/box/android/domain/models/DomainModel;", "x", "", "y", "<init>", "(DD)V", "getX", "()D", "getY", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationPoint implements DomainModel {
    private final double x;
    private final double y;

    public static /* synthetic */ AnnotationPoint copy$default(AnnotationPoint annotationPoint, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = annotationPoint.x;
        }
        if ((i & 2) != 0) {
            d2 = annotationPoint.y;
        }
        return annotationPoint.copy(d, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getY() {
        return this.y;
    }

    public final AnnotationPoint copy(double x, double y) {
        return new AnnotationPoint(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationPoint)) {
            return false;
        }
        AnnotationPoint annotationPoint = (AnnotationPoint) other;
        return Double.compare(this.x, annotationPoint.x) == 0 && Double.compare(this.y, annotationPoint.y) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.x) * 31) + Double.hashCode(this.y);
    }

    public String toString() {
        return "AnnotationPoint(x=" + this.x + ", y=" + this.y + ")";
    }

    public AnnotationPoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }
}
