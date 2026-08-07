package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/annotations/Stroke;", "", "color", "", "size", "", "<init>", "(Ljava/lang/String;F)V", "getColor", "()Ljava/lang/String;", "getSize", "()F", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Stroke {
    private final String color;
    private final float size;

    public static /* synthetic */ Stroke copy$default(Stroke stroke, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stroke.color;
        }
        if ((i & 2) != 0) {
            f = stroke.size;
        }
        return stroke.copy(str, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getSize() {
        return this.size;
    }

    public final Stroke copy(@Json(name = "color") String color, @Json(name = "size") float size) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new Stroke(color, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) other;
        return Intrinsics.areEqual(this.color, stroke.color) && Float.compare(this.size, stroke.size) == 0;
    }

    public int hashCode() {
        return (this.color.hashCode() * 31) + Float.hashCode(this.size);
    }

    public String toString() {
        return "Stroke(color=" + this.color + ", size=" + this.size + ")";
    }

    public Stroke(@Json(name = "color") String color, @Json(name = "size") float f) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.size = f;
    }

    public final String getColor() {
        return this.color;
    }

    public final float getSize() {
        return this.size;
    }
}
