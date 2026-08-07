package com.box.android.preview.annotations.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Annotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "", "annotation", "Lcom/box/android/preview/annotations/model/Annotation;", "locationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "canDeletePermission", "", "<init>", "(Lcom/box/android/preview/annotations/model/Annotation;Lcom/box/android/domain/models/annotations/AnnotationLocationModel;Z)V", "getAnnotation", "()Lcom/box/android/preview/annotations/model/Annotation;", "getLocationModel", "()Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "getCanDeletePermission", "()Z", "hashCode", "", "equals", "other", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationWithLocation {
    public static final int $stable = 8;
    private final Annotation annotation;
    private final boolean canDeletePermission;
    private final AnnotationLocationModel locationModel;

    public static /* synthetic */ AnnotationWithLocation copy$default(AnnotationWithLocation annotationWithLocation, Annotation annotation, AnnotationLocationModel annotationLocationModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            annotation = annotationWithLocation.annotation;
        }
        if ((i & 2) != 0) {
            annotationLocationModel = annotationWithLocation.locationModel;
        }
        if ((i & 4) != 0) {
            z = annotationWithLocation.canDeletePermission;
        }
        return annotationWithLocation.copy(annotation, annotationLocationModel, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Annotation getAnnotation() {
        return this.annotation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AnnotationLocationModel getLocationModel() {
        return this.locationModel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanDeletePermission() {
        return this.canDeletePermission;
    }

    public final AnnotationWithLocation copy(Annotation annotation, AnnotationLocationModel locationModel, boolean canDeletePermission) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(locationModel, "locationModel");
        return new AnnotationWithLocation(annotation, locationModel, canDeletePermission);
    }

    public String toString() {
        return "AnnotationWithLocation(annotation=" + this.annotation + ", locationModel=" + this.locationModel + ", canDeletePermission=" + this.canDeletePermission + ")";
    }

    public AnnotationWithLocation(Annotation annotation, AnnotationLocationModel locationModel, boolean z) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(locationModel, "locationModel");
        this.annotation = annotation;
        this.locationModel = locationModel;
        this.canDeletePermission = z;
    }

    public /* synthetic */ AnnotationWithLocation(Annotation annotation, AnnotationLocationModel annotationLocationModel, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotation, annotationLocationModel, (i & 4) != 0 ? false : z);
    }

    public final Annotation getAnnotation() {
        return this.annotation;
    }

    public final AnnotationLocationModel getLocationModel() {
        return this.locationModel;
    }

    public final boolean getCanDeletePermission() {
        return this.canDeletePermission;
    }

    public int hashCode() {
        return this.annotation.getAnnotationId().hashCode();
    }

    public boolean equals(Object other) {
        if (other instanceof AnnotationWithLocation) {
            AnnotationWithLocation annotationWithLocation = (AnnotationWithLocation) other;
            if (AnnotationKt.compare(this.annotation, annotationWithLocation.annotation) && Intrinsics.areEqual(this.locationModel, annotationWithLocation.locationModel) && this.canDeletePermission == annotationWithLocation.canDeletePermission) {
                return true;
            }
        }
        return false;
    }
}
