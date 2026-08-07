package com.box.android.data.api.models.watermark;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkResponseDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/models/watermark/WatermarkDetailsDTO;", "", "createdAt", "", "modifiedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCreatedAt", "()Ljava/lang/String;", "getModifiedAt", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WatermarkDetailsDTO {
    private final String createdAt;
    private final String modifiedAt;

    /* JADX WARN: Multi-variable type inference failed */
    public WatermarkDetailsDTO() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WatermarkDetailsDTO copy$default(WatermarkDetailsDTO watermarkDetailsDTO, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watermarkDetailsDTO.createdAt;
        }
        if ((i & 2) != 0) {
            str2 = watermarkDetailsDTO.modifiedAt;
        }
        return watermarkDetailsDTO.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModifiedAt() {
        return this.modifiedAt;
    }

    public final WatermarkDetailsDTO copy(@Json(name = "created_at") String createdAt, @Json(name = "modified_at") String modifiedAt) {
        return new WatermarkDetailsDTO(createdAt, modifiedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatermarkDetailsDTO)) {
            return false;
        }
        WatermarkDetailsDTO watermarkDetailsDTO = (WatermarkDetailsDTO) other;
        return Intrinsics.areEqual(this.createdAt, watermarkDetailsDTO.createdAt) && Intrinsics.areEqual(this.modifiedAt, watermarkDetailsDTO.modifiedAt);
    }

    public int hashCode() {
        String str = this.createdAt;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.modifiedAt;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "WatermarkDetailsDTO(createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ")";
    }

    public WatermarkDetailsDTO(@Json(name = "created_at") String str, @Json(name = "modified_at") String str2) {
        this.createdAt = str;
        this.modifiedAt = str2;
    }

    public /* synthetic */ WatermarkDetailsDTO(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getModifiedAt() {
        return this.modifiedAt;
    }
}
