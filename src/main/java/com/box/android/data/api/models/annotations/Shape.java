package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/box/android/data/api/models/annotations/Shape;", "", "height", "", "width", "x", "y", "stroke", "Lcom/box/android/data/api/models/annotations/Stroke;", "type", "Lcom/box/android/data/api/models/annotations/ShapeType;", "<init>", "(DDDDLcom/box/android/data/api/models/annotations/Stroke;Lcom/box/android/data/api/models/annotations/ShapeType;)V", "getHeight", "()D", "getWidth", "getX", "getY", "getStroke", "()Lcom/box/android/data/api/models/annotations/Stroke;", "getType", "()Lcom/box/android/data/api/models/annotations/ShapeType;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Shape {
    private final double height;
    private final Stroke stroke;
    private final ShapeType type;
    private final double width;
    private final double x;
    private final double y;

    public static /* synthetic */ Shape copy$default(Shape shape, double d, double d2, double d3, double d4, Stroke stroke, ShapeType shapeType, int i, Object obj) {
        if ((i & 1) != 0) {
            d = shape.height;
        }
        double d5 = d;
        if ((i & 2) != 0) {
            d2 = shape.width;
        }
        return shape.copy(d5, d2, (i & 4) != 0 ? shape.x : d3, (i & 8) != 0 ? shape.y : d4, (i & 16) != 0 ? shape.stroke : stroke, (i & 32) != 0 ? shape.type : shapeType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Stroke getStroke() {
        return this.stroke;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ShapeType getType() {
        return this.type;
    }

    public final Shape copy(@Json(name = "height") double height, @Json(name = "width") double width, @Json(name = "x") double x, @Json(name = "y") double y, @Json(name = "stroke") Stroke stroke, @Json(name = "type") ShapeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new Shape(height, width, x, y, stroke, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shape)) {
            return false;
        }
        Shape shape = (Shape) other;
        return Double.compare(this.height, shape.height) == 0 && Double.compare(this.width, shape.width) == 0 && Double.compare(this.x, shape.x) == 0 && Double.compare(this.y, shape.y) == 0 && Intrinsics.areEqual(this.stroke, shape.stroke) && this.type == shape.type;
    }

    public int hashCode() {
        int iHashCode = ((((((Double.hashCode(this.height) * 31) + Double.hashCode(this.width)) * 31) + Double.hashCode(this.x)) * 31) + Double.hashCode(this.y)) * 31;
        Stroke stroke = this.stroke;
        return ((iHashCode + (stroke == null ? 0 : stroke.hashCode())) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Shape(height=" + this.height + ", width=" + this.width + ", x=" + this.x + ", y=" + this.y + ", stroke=" + this.stroke + ", type=" + this.type + ")";
    }

    public Shape(@Json(name = "height") double d, @Json(name = "width") double d2, @Json(name = "x") double d3, @Json(name = "y") double d4, @Json(name = "stroke") Stroke stroke, @Json(name = "type") ShapeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.height = d;
        this.width = d2;
        this.x = d3;
        this.y = d4;
        this.stroke = stroke;
        this.type = type;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final Stroke getStroke() {
        return this.stroke;
    }

    public final ShapeType getType() {
        return this.type;
    }
}
