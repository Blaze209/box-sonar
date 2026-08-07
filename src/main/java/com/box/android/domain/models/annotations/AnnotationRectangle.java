package com.box.android.domain.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationRectangle;", "Lcom/box/android/domain/models/DomainModel;", ViewProps.TOP, "", "left", "height", "width", "<init>", "(DDDD)V", "getTop", "()D", "getLeft", "getHeight", "getWidth", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationRectangle implements DomainModel {
    private final double height;
    private final double left;
    private final double top;
    private final double width;

    public static /* synthetic */ AnnotationRectangle copy$default(AnnotationRectangle annotationRectangle, double d, double d2, double d3, double d4, int i, Object obj) {
        if ((i & 1) != 0) {
            d = annotationRectangle.top;
        }
        double d5 = d;
        if ((i & 2) != 0) {
            d2 = annotationRectangle.left;
        }
        double d6 = d2;
        if ((i & 4) != 0) {
            d3 = annotationRectangle.height;
        }
        return annotationRectangle.copy(d5, d6, d3, (i & 8) != 0 ? annotationRectangle.width : d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    public final AnnotationRectangle copy(double top, double left, double height, double width) {
        return new AnnotationRectangle(top, left, height, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationRectangle)) {
            return false;
        }
        AnnotationRectangle annotationRectangle = (AnnotationRectangle) other;
        return Double.compare(this.top, annotationRectangle.top) == 0 && Double.compare(this.left, annotationRectangle.left) == 0 && Double.compare(this.height, annotationRectangle.height) == 0 && Double.compare(this.width, annotationRectangle.width) == 0;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.top) * 31) + Double.hashCode(this.left)) * 31) + Double.hashCode(this.height)) * 31) + Double.hashCode(this.width);
    }

    public String toString() {
        return "AnnotationRectangle(top=" + this.top + ", left=" + this.left + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public AnnotationRectangle(double d, double d2, double d3, double d4) {
        this.top = d;
        this.left = d2;
        this.height = d3;
        this.width = d4;
    }

    public final double getTop() {
        return this.top;
    }

    public final double getLeft() {
        return this.left;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }
}
