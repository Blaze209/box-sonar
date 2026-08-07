package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/annotations/Location;", "", "type", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getType", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Location {
    public static final String TYPE_FRAME = "frame";
    public static final String TYPE_PAGE = "page";
    private final String type;
    private final int value;

    public static /* synthetic */ Location copy$default(Location location, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = location.type;
        }
        if ((i2 & 2) != 0) {
            i = location.value;
        }
        return location.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final Location copy(@Json(name = "type") String type, @Json(name = "value") int value) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new Location(type, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location location = (Location) other;
        return Intrinsics.areEqual(this.type, location.type) && this.value == location.value;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        return "Location(type=" + this.type + ", value=" + this.value + ")";
    }

    public Location(@Json(name = "type") String type, @Json(name = "value") int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.value = i;
    }

    public final String getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }
}
