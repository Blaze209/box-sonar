package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0013\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/api/models/annotations/TargetDTO;", "", "type", "Lcom/box/android/data/api/models/annotations/TargetType;", "<init>", "(Lcom/box/android/data/api/models/annotations/TargetType;)V", "getType", "()Lcom/box/android/data/api/models/annotations/TargetType;", "Region", "Highlight", "Drawing", "Lcom/box/android/data/api/models/annotations/TargetDTO$Drawing;", "Lcom/box/android/data/api/models/annotations/TargetDTO$Highlight;", "Lcom/box/android/data/api/models/annotations/TargetDTO$Region;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TargetDTO {
    private final TargetType type;

    public /* synthetic */ TargetDTO(TargetType targetType, DefaultConstructorMarker defaultConstructorMarker) {
        this(targetType);
    }

    private TargetDTO(@Json(name = "type") TargetType targetType) {
        this.type = targetType;
    }

    public final TargetType getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: TargetDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/api/models/annotations/TargetDTO$Region;", "Lcom/box/android/data/api/models/annotations/TargetDTO;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/data/api/models/annotations/Location;", "shape", "Lcom/box/android/data/api/models/annotations/Shape;", "<init>", "(Lcom/box/android/data/api/models/annotations/Location;Lcom/box/android/data/api/models/annotations/Shape;)V", "getLocation", "()Lcom/box/android/data/api/models/annotations/Location;", "getShape", "()Lcom/box/android/data/api/models/annotations/Shape;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Region extends TargetDTO {
        private final Location location;
        private final Shape shape;

        public static /* synthetic */ Region copy$default(Region region, Location location, Shape shape, int i, Object obj) {
            if ((i & 1) != 0) {
                location = region.location;
            }
            if ((i & 2) != 0) {
                shape = region.shape;
            }
            return region.copy(location, shape);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Location getLocation() {
            return this.location;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Shape getShape() {
            return this.shape;
        }

        public final Region copy(@Json(name = FirebaseAnalytics.Param.LOCATION) Location location, @Json(name = "shape") Shape shape) {
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(shape, "shape");
            return new Region(location, shape);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Region)) {
                return false;
            }
            Region region = (Region) other;
            return Intrinsics.areEqual(this.location, region.location) && Intrinsics.areEqual(this.shape, region.shape);
        }

        public int hashCode() {
            return (this.location.hashCode() * 31) + this.shape.hashCode();
        }

        public String toString() {
            return "Region(location=" + this.location + ", shape=" + this.shape + ")";
        }

        public final Location getLocation() {
            return this.location;
        }

        public final Shape getShape() {
            return this.shape;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Region(@Json(name = FirebaseAnalytics.Param.LOCATION) Location location, @Json(name = "shape") Shape shape) {
            super(TargetType.REGION, null);
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.location = location;
            this.shape = shape;
        }
    }

    /* JADX INFO: compiled from: TargetDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/annotations/TargetDTO$Highlight;", "Lcom/box/android/data/api/models/annotations/TargetDTO;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/data/api/models/annotations/Location;", "shapes", "", "Lcom/box/android/data/api/models/annotations/Shape;", "<init>", "(Lcom/box/android/data/api/models/annotations/Location;Ljava/util/List;)V", "getLocation", "()Lcom/box/android/data/api/models/annotations/Location;", "getShapes", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Highlight extends TargetDTO {
        private final Location location;
        private final List<Shape> shapes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Highlight copy$default(Highlight highlight, Location location, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                location = highlight.location;
            }
            if ((i & 2) != 0) {
                list = highlight.shapes;
            }
            return highlight.copy(location, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Location getLocation() {
            return this.location;
        }

        public final List<Shape> component2() {
            return this.shapes;
        }

        public final Highlight copy(@Json(name = FirebaseAnalytics.Param.LOCATION) Location location, @Json(name = "shapes") List<Shape> shapes) {
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(shapes, "shapes");
            return new Highlight(location, shapes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Highlight)) {
                return false;
            }
            Highlight highlight = (Highlight) other;
            return Intrinsics.areEqual(this.location, highlight.location) && Intrinsics.areEqual(this.shapes, highlight.shapes);
        }

        public int hashCode() {
            return (this.location.hashCode() * 31) + this.shapes.hashCode();
        }

        public String toString() {
            return "Highlight(location=" + this.location + ", shapes=" + this.shapes + ")";
        }

        public final Location getLocation() {
            return this.location;
        }

        public final List<Shape> getShapes() {
            return this.shapes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Highlight(@Json(name = FirebaseAnalytics.Param.LOCATION) Location location, @Json(name = "shapes") List<Shape> shapes) {
            super(TargetType.HIGHLIGHT, null);
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(shapes, "shapes");
            this.location = location;
            this.shapes = shapes;
        }
    }

    /* JADX INFO: compiled from: TargetDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/annotations/TargetDTO$Drawing;", "Lcom/box/android/data/api/models/annotations/TargetDTO;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/data/api/models/annotations/Location;", "pathGroups", "", "Lcom/box/android/data/api/models/annotations/PathGroup;", "<init>", "(Lcom/box/android/data/api/models/annotations/Location;Ljava/util/List;)V", "getLocation", "()Lcom/box/android/data/api/models/annotations/Location;", "getPathGroups", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Drawing extends TargetDTO {
        private final Location location;
        private final List<PathGroup> pathGroups;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Drawing copy$default(Drawing drawing, Location location, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                location = drawing.location;
            }
            if ((i & 2) != 0) {
                list = drawing.pathGroups;
            }
            return drawing.copy(location, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Location getLocation() {
            return this.location;
        }

        public final List<PathGroup> component2() {
            return this.pathGroups;
        }

        public final Drawing copy(@Json(name = FirebaseAnalytics.Param.LOCATION) Location location, @Json(name = "path_groups") List<PathGroup> pathGroups) {
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(pathGroups, "pathGroups");
            return new Drawing(location, pathGroups);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Drawing)) {
                return false;
            }
            Drawing drawing = (Drawing) other;
            return Intrinsics.areEqual(this.location, drawing.location) && Intrinsics.areEqual(this.pathGroups, drawing.pathGroups);
        }

        public int hashCode() {
            return (this.location.hashCode() * 31) + this.pathGroups.hashCode();
        }

        public String toString() {
            return "Drawing(location=" + this.location + ", pathGroups=" + this.pathGroups + ")";
        }

        public final Location getLocation() {
            return this.location;
        }

        public final List<PathGroup> getPathGroups() {
            return this.pathGroups;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drawing(@Json(name = FirebaseAnalytics.Param.LOCATION) Location location, @Json(name = "path_groups") List<PathGroup> pathGroups) {
            super(TargetType.DRAWING, null);
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(pathGroups, "pathGroups");
            this.location = location;
            this.pathGroups = pathGroups;
        }
    }
}
