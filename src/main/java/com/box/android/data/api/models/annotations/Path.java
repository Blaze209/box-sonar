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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/Path;", "", "points", "", "Lcom/box/android/data/api/models/annotations/Point;", "<init>", "(Ljava/util/List;)V", "getPoints", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Path {
    private final List<Point> points;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Path copy$default(Path path, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = path.points;
        }
        return path.copy(list);
    }

    public final List<Point> component1() {
        return this.points;
    }

    public final Path copy(@Json(name = "points") List<Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        return new Path(points);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Path) && Intrinsics.areEqual(this.points, ((Path) other).points);
    }

    public int hashCode() {
        return this.points.hashCode();
    }

    public String toString() {
        return "Path(points=" + this.points + ")";
    }

    public Path(@Json(name = "points") List<Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
    }

    public final List<Point> getPoints() {
        return this.points;
    }
}
