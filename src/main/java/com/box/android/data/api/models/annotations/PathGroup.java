package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/api/models/annotations/PathGroup;", "", "stroke", "Lcom/box/android/data/api/models/annotations/Stroke;", "paths", "", "Lcom/box/android/data/api/models/annotations/Path;", "<init>", "(Lcom/box/android/data/api/models/annotations/Stroke;Ljava/util/List;)V", "getStroke", "()Lcom/box/android/data/api/models/annotations/Stroke;", "getPaths", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PathGroup {
    private final List<Path> paths;
    private final Stroke stroke;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PathGroup copy$default(PathGroup pathGroup, Stroke stroke, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            stroke = pathGroup.stroke;
        }
        if ((i & 2) != 0) {
            list = pathGroup.paths;
        }
        return pathGroup.copy(stroke, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Stroke getStroke() {
        return this.stroke;
    }

    public final List<Path> component2() {
        return this.paths;
    }

    public final PathGroup copy(@Json(name = "stroke") Stroke stroke, @Json(name = "paths") List<Path> paths) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        Intrinsics.checkNotNullParameter(paths, "paths");
        return new PathGroup(stroke, paths);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathGroup)) {
            return false;
        }
        PathGroup pathGroup = (PathGroup) other;
        return Intrinsics.areEqual(this.stroke, pathGroup.stroke) && Intrinsics.areEqual(this.paths, pathGroup.paths);
    }

    public int hashCode() {
        return (this.stroke.hashCode() * 31) + this.paths.hashCode();
    }

    public String toString() {
        return "PathGroup(stroke=" + this.stroke + ", paths=" + this.paths + ")";
    }

    public PathGroup(@Json(name = "stroke") Stroke stroke, @Json(name = "paths") List<Path> paths) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        Intrinsics.checkNotNullParameter(paths, "paths");
        this.stroke = stroke;
        this.paths = paths;
    }

    public final List<Path> getPaths() {
        return this.paths;
    }

    public final Stroke getStroke() {
        return this.stroke;
    }
}
