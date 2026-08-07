package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxWatermark;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WatermarkDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/models/WatermarkDTO;", "", "isWatermarked", "", "isWatermarkInherited", "isWatermarkedByAccessPolicy", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WatermarkDTO {
    private final boolean isWatermarkInherited;
    private final boolean isWatermarked;
    private final boolean isWatermarkedByAccessPolicy;

    public WatermarkDTO() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ WatermarkDTO copy$default(WatermarkDTO watermarkDTO, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = watermarkDTO.isWatermarked;
        }
        if ((i & 2) != 0) {
            z2 = watermarkDTO.isWatermarkInherited;
        }
        if ((i & 4) != 0) {
            z3 = watermarkDTO.isWatermarkedByAccessPolicy;
        }
        return watermarkDTO.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsWatermarked() {
        return this.isWatermarked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsWatermarkInherited() {
        return this.isWatermarkInherited;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsWatermarkedByAccessPolicy() {
        return this.isWatermarkedByAccessPolicy;
    }

    public final WatermarkDTO copy(@Json(name = BoxWatermark.FIELD_IS_WATERMARKED) boolean isWatermarked, @Json(name = BoxWatermark.FIELD_IS_WATERMARK_INHERITED) boolean isWatermarkInherited, @Json(name = BoxWatermark.FIELD_IS_WATERMARKED_BY_ACCESS_POLICY) boolean isWatermarkedByAccessPolicy) {
        return new WatermarkDTO(isWatermarked, isWatermarkInherited, isWatermarkedByAccessPolicy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatermarkDTO)) {
            return false;
        }
        WatermarkDTO watermarkDTO = (WatermarkDTO) other;
        return this.isWatermarked == watermarkDTO.isWatermarked && this.isWatermarkInherited == watermarkDTO.isWatermarkInherited && this.isWatermarkedByAccessPolicy == watermarkDTO.isWatermarkedByAccessPolicy;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isWatermarked) * 31) + Boolean.hashCode(this.isWatermarkInherited)) * 31) + Boolean.hashCode(this.isWatermarkedByAccessPolicy);
    }

    public String toString() {
        return "WatermarkDTO(isWatermarked=" + this.isWatermarked + ", isWatermarkInherited=" + this.isWatermarkInherited + ", isWatermarkedByAccessPolicy=" + this.isWatermarkedByAccessPolicy + ")";
    }

    public WatermarkDTO(@Json(name = BoxWatermark.FIELD_IS_WATERMARKED) boolean z, @Json(name = BoxWatermark.FIELD_IS_WATERMARK_INHERITED) boolean z2, @Json(name = BoxWatermark.FIELD_IS_WATERMARKED_BY_ACCESS_POLICY) boolean z3) {
        this.isWatermarked = z;
        this.isWatermarkInherited = z2;
        this.isWatermarkedByAccessPolicy = z3;
    }

    public /* synthetic */ WatermarkDTO(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean isWatermarked() {
        return this.isWatermarked;
    }

    public final boolean isWatermarkInherited() {
        return this.isWatermarkInherited;
    }

    public final boolean isWatermarkedByAccessPolicy() {
        return this.isWatermarkedByAccessPolicy;
    }
}
