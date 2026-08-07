package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationPathGroup;", "", "stroke", "Lcom/box/android/domain/models/annotations/AnnotationStroke;", "paths", "", "Lcom/box/android/domain/models/annotations/AnnotationPath;", "<init>", "(Lcom/box/android/domain/models/annotations/AnnotationStroke;Ljava/util/List;)V", "getStroke", "()Lcom/box/android/domain/models/annotations/AnnotationStroke;", "getPaths", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationPathGroup {
    private final List<AnnotationPath> paths;
    private final AnnotationStroke stroke;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationPathGroup copy$default(AnnotationPathGroup annotationPathGroup, AnnotationStroke annotationStroke, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            annotationStroke = annotationPathGroup.stroke;
        }
        if ((i & 2) != 0) {
            list = annotationPathGroup.paths;
        }
        return annotationPathGroup.copy(annotationStroke, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AnnotationStroke getStroke() {
        return this.stroke;
    }

    public final List<AnnotationPath> component2() {
        return this.paths;
    }

    public final AnnotationPathGroup copy(AnnotationStroke stroke, List<AnnotationPath> paths) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        Intrinsics.checkNotNullParameter(paths, "paths");
        return new AnnotationPathGroup(stroke, paths);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationPathGroup)) {
            return false;
        }
        AnnotationPathGroup annotationPathGroup = (AnnotationPathGroup) other;
        return Intrinsics.areEqual(this.stroke, annotationPathGroup.stroke) && Intrinsics.areEqual(this.paths, annotationPathGroup.paths);
    }

    public int hashCode() {
        return (this.stroke.hashCode() * 31) + this.paths.hashCode();
    }

    public String toString() {
        return "AnnotationPathGroup(stroke=" + this.stroke + ", paths=" + this.paths + ")";
    }

    public AnnotationPathGroup(AnnotationStroke stroke, List<AnnotationPath> paths) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        Intrinsics.checkNotNullParameter(paths, "paths");
        this.stroke = stroke;
        this.paths = paths;
    }

    public final List<AnnotationPath> getPaths() {
        return this.paths;
    }

    public final AnnotationStroke getStroke() {
        return this.stroke;
    }
}
