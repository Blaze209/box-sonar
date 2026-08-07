package com.box.android.data.api.models.watermark;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplyWatermarkRequestDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/models/watermark/WatermarkImprintDTO;", "", "imprint", "", "<init>", "(Ljava/lang/String;)V", "getImprint", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WatermarkImprintDTO {
    private final String imprint;

    /* JADX WARN: Multi-variable type inference failed */
    public WatermarkImprintDTO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WatermarkImprintDTO copy$default(WatermarkImprintDTO watermarkImprintDTO, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watermarkImprintDTO.imprint;
        }
        return watermarkImprintDTO.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImprint() {
        return this.imprint;
    }

    public final WatermarkImprintDTO copy(@Json(name = "imprint") String imprint) {
        Intrinsics.checkNotNullParameter(imprint, "imprint");
        return new WatermarkImprintDTO(imprint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WatermarkImprintDTO) && Intrinsics.areEqual(this.imprint, ((WatermarkImprintDTO) other).imprint);
    }

    public int hashCode() {
        return this.imprint.hashCode();
    }

    public String toString() {
        return "WatermarkImprintDTO(imprint=" + this.imprint + ")";
    }

    public WatermarkImprintDTO(@Json(name = "imprint") String imprint) {
        Intrinsics.checkNotNullParameter(imprint, "imprint");
        this.imprint = imprint;
    }

    public /* synthetic */ WatermarkImprintDTO(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default" : str);
    }

    public final String getImprint() {
        return this.imprint;
    }
}
