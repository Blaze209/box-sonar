package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/RepresentationStatusDTO;", "", "representationState", "Lcom/box/android/data/api/models/RepresentationState;", "code", "", "<init>", "(Lcom/box/android/data/api/models/RepresentationState;Ljava/lang/String;)V", "getRepresentationState", "()Lcom/box/android/data/api/models/RepresentationState;", "getCode", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationStatusDTO {
    private final String code;
    private final RepresentationState representationState;

    public static /* synthetic */ RepresentationStatusDTO copy$default(RepresentationStatusDTO representationStatusDTO, RepresentationState representationState, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            representationState = representationStatusDTO.representationState;
        }
        if ((i & 2) != 0) {
            str = representationStatusDTO.code;
        }
        return representationStatusDTO.copy(representationState, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RepresentationState getRepresentationState() {
        return this.representationState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final RepresentationStatusDTO copy(@Json(name = "state") RepresentationState representationState, @Json(name = "code") String code) {
        Intrinsics.checkNotNullParameter(representationState, "representationState");
        return new RepresentationStatusDTO(representationState, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepresentationStatusDTO)) {
            return false;
        }
        RepresentationStatusDTO representationStatusDTO = (RepresentationStatusDTO) other;
        return this.representationState == representationStatusDTO.representationState && Intrinsics.areEqual(this.code, representationStatusDTO.code);
    }

    public int hashCode() {
        int iHashCode = this.representationState.hashCode() * 31;
        String str = this.code;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RepresentationStatusDTO(representationState=" + this.representationState + ", code=" + this.code + ")";
    }

    public RepresentationStatusDTO(@Json(name = "state") RepresentationState representationState, @Json(name = "code") String str) {
        Intrinsics.checkNotNullParameter(representationState, "representationState");
        this.representationState = representationState;
        this.code = str;
    }

    public final RepresentationState getRepresentationState() {
        return this.representationState;
    }

    public final String getCode() {
        return this.code;
    }
}
