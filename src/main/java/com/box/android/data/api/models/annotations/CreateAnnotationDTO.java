package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateAnnotationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/annotations/CreateAnnotationDTO;", "", "fileVersionDTO", "Lcom/box/android/data/api/models/annotations/ReferenceDTO;", "description", "Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "targetDTO", "Lcom/box/android/data/api/models/annotations/TargetDTO;", "<init>", "(Lcom/box/android/data/api/models/annotations/ReferenceDTO;Lcom/box/android/data/api/models/annotations/DescriptionDTO;Lcom/box/android/data/api/models/annotations/TargetDTO;)V", "getFileVersionDTO", "()Lcom/box/android/data/api/models/annotations/ReferenceDTO;", "getDescription", "()Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "getTargetDTO", "()Lcom/box/android/data/api/models/annotations/TargetDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CreateAnnotationDTO {
    private final DescriptionDTO description;
    private final ReferenceDTO fileVersionDTO;
    private final TargetDTO targetDTO;

    public static /* synthetic */ CreateAnnotationDTO copy$default(CreateAnnotationDTO createAnnotationDTO, ReferenceDTO referenceDTO, DescriptionDTO descriptionDTO, TargetDTO targetDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            referenceDTO = createAnnotationDTO.fileVersionDTO;
        }
        if ((i & 2) != 0) {
            descriptionDTO = createAnnotationDTO.description;
        }
        if ((i & 4) != 0) {
            targetDTO = createAnnotationDTO.targetDTO;
        }
        return createAnnotationDTO.copy(referenceDTO, descriptionDTO, targetDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ReferenceDTO getFileVersionDTO() {
        return this.fileVersionDTO;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DescriptionDTO getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TargetDTO getTargetDTO() {
        return this.targetDTO;
    }

    public final CreateAnnotationDTO copy(@Json(name = "file_version") ReferenceDTO fileVersionDTO, @Json(name = "description") DescriptionDTO description, @Json(name = "target") TargetDTO targetDTO) {
        Intrinsics.checkNotNullParameter(fileVersionDTO, "fileVersionDTO");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(targetDTO, "targetDTO");
        return new CreateAnnotationDTO(fileVersionDTO, description, targetDTO);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateAnnotationDTO)) {
            return false;
        }
        CreateAnnotationDTO createAnnotationDTO = (CreateAnnotationDTO) other;
        return Intrinsics.areEqual(this.fileVersionDTO, createAnnotationDTO.fileVersionDTO) && Intrinsics.areEqual(this.description, createAnnotationDTO.description) && Intrinsics.areEqual(this.targetDTO, createAnnotationDTO.targetDTO);
    }

    public int hashCode() {
        return (((this.fileVersionDTO.hashCode() * 31) + this.description.hashCode()) * 31) + this.targetDTO.hashCode();
    }

    public String toString() {
        return "CreateAnnotationDTO(fileVersionDTO=" + this.fileVersionDTO + ", description=" + this.description + ", targetDTO=" + this.targetDTO + ")";
    }

    public CreateAnnotationDTO(@Json(name = "file_version") ReferenceDTO fileVersionDTO, @Json(name = "description") DescriptionDTO description, @Json(name = "target") TargetDTO targetDTO) {
        Intrinsics.checkNotNullParameter(fileVersionDTO, "fileVersionDTO");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(targetDTO, "targetDTO");
        this.fileVersionDTO = fileVersionDTO;
        this.description = description;
        this.targetDTO = targetDTO;
    }

    public final ReferenceDTO getFileVersionDTO() {
        return this.fileVersionDTO;
    }

    public final DescriptionDTO getDescription() {
        return this.description;
    }

    public final TargetDTO getTargetDTO() {
        return this.targetDTO;
    }
}
