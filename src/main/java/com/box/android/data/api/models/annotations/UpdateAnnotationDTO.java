package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateAnnotationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/annotations/UpdateAnnotationDTO;", "", "description", "Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "status", "", "<init>", "(Lcom/box/android/data/api/models/annotations/DescriptionDTO;Ljava/lang/String;)V", "getDescription", "()Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "getStatus", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UpdateAnnotationDTO {
    private final DescriptionDTO description;
    private final String status;

    public static /* synthetic */ UpdateAnnotationDTO copy$default(UpdateAnnotationDTO updateAnnotationDTO, DescriptionDTO descriptionDTO, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            descriptionDTO = updateAnnotationDTO.description;
        }
        if ((i & 2) != 0) {
            str = updateAnnotationDTO.status;
        }
        return updateAnnotationDTO.copy(descriptionDTO, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DescriptionDTO getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final UpdateAnnotationDTO copy(@Json(name = "description") DescriptionDTO description, @Json(name = "status") String status) {
        return new UpdateAnnotationDTO(description, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateAnnotationDTO)) {
            return false;
        }
        UpdateAnnotationDTO updateAnnotationDTO = (UpdateAnnotationDTO) other;
        return Intrinsics.areEqual(this.description, updateAnnotationDTO.description) && Intrinsics.areEqual(this.status, updateAnnotationDTO.status);
    }

    public int hashCode() {
        DescriptionDTO descriptionDTO = this.description;
        int iHashCode = (descriptionDTO == null ? 0 : descriptionDTO.hashCode()) * 31;
        String str = this.status;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UpdateAnnotationDTO(description=" + this.description + ", status=" + this.status + ")";
    }

    public UpdateAnnotationDTO(@Json(name = "description") DescriptionDTO descriptionDTO, @Json(name = "status") String str) {
        this.description = descriptionDTO;
        this.status = str;
    }

    public final DescriptionDTO getDescription() {
        return this.description;
    }

    public final String getStatus() {
        return this.status;
    }
}
