package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationStroke;", "Lcom/box/android/domain/models/DomainModel;", "color", "", "width", "", "<init>", "(Ljava/lang/String;F)V", "getColor", "()Ljava/lang/String;", "getWidth", "()F", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationStroke implements DomainModel {
    private final String color;
    private final float width;

    public static /* synthetic */ AnnotationStroke copy$default(AnnotationStroke annotationStroke, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = annotationStroke.color;
        }
        if ((i & 2) != 0) {
            f = annotationStroke.width;
        }
        return annotationStroke.copy(str, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public final AnnotationStroke copy(String color, float width) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new AnnotationStroke(color, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationStroke)) {
            return false;
        }
        AnnotationStroke annotationStroke = (AnnotationStroke) other;
        return Intrinsics.areEqual(this.color, annotationStroke.color) && Float.compare(this.width, annotationStroke.width) == 0;
    }

    public int hashCode() {
        return (this.color.hashCode() * 31) + Float.hashCode(this.width);
    }

    public String toString() {
        return "AnnotationStroke(color=" + this.color + ", width=" + this.width + ")";
    }

    public AnnotationStroke(String color, float f) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.width = f;
    }

    public final String getColor() {
        return this.color;
    }

    public final float getWidth() {
        return this.width;
    }
}
