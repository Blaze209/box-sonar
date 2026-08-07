package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/box/android/data/api/models/RepresentationDTO;", "", "content", "Lcom/box/android/data/api/models/RepresentationContentDTO;", BoxRepresentation.FIELD_INFO, "Lcom/box/android/data/api/models/RepresentationInfoDTO;", "properties", "Lcom/box/android/data/api/models/RepresentationPropertiesDTO;", "representationType", "Lcom/box/android/data/api/models/RepresentationTypeDTO;", "status", "Lcom/box/android/data/api/models/RepresentationStatusDTO;", "<init>", "(Lcom/box/android/data/api/models/RepresentationContentDTO;Lcom/box/android/data/api/models/RepresentationInfoDTO;Lcom/box/android/data/api/models/RepresentationPropertiesDTO;Lcom/box/android/data/api/models/RepresentationTypeDTO;Lcom/box/android/data/api/models/RepresentationStatusDTO;)V", "getContent", "()Lcom/box/android/data/api/models/RepresentationContentDTO;", "getInfo", "()Lcom/box/android/data/api/models/RepresentationInfoDTO;", "getProperties", "()Lcom/box/android/data/api/models/RepresentationPropertiesDTO;", "getRepresentationType", "()Lcom/box/android/data/api/models/RepresentationTypeDTO;", "getStatus", "()Lcom/box/android/data/api/models/RepresentationStatusDTO;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationDTO {
    private final RepresentationContentDTO content;
    private final RepresentationInfoDTO info;
    private final RepresentationPropertiesDTO properties;
    private final RepresentationTypeDTO representationType;
    private final RepresentationStatusDTO status;

    public static /* synthetic */ RepresentationDTO copy$default(RepresentationDTO representationDTO, RepresentationContentDTO representationContentDTO, RepresentationInfoDTO representationInfoDTO, RepresentationPropertiesDTO representationPropertiesDTO, RepresentationTypeDTO representationTypeDTO, RepresentationStatusDTO representationStatusDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            representationContentDTO = representationDTO.content;
        }
        if ((i & 2) != 0) {
            representationInfoDTO = representationDTO.info;
        }
        if ((i & 4) != 0) {
            representationPropertiesDTO = representationDTO.properties;
        }
        if ((i & 8) != 0) {
            representationTypeDTO = representationDTO.representationType;
        }
        if ((i & 16) != 0) {
            representationStatusDTO = representationDTO.status;
        }
        RepresentationStatusDTO representationStatusDTO2 = representationStatusDTO;
        RepresentationPropertiesDTO representationPropertiesDTO2 = representationPropertiesDTO;
        return representationDTO.copy(representationContentDTO, representationInfoDTO, representationPropertiesDTO2, representationTypeDTO, representationStatusDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RepresentationContentDTO getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RepresentationInfoDTO getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RepresentationPropertiesDTO getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RepresentationTypeDTO getRepresentationType() {
        return this.representationType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final RepresentationStatusDTO getStatus() {
        return this.status;
    }

    public final RepresentationDTO copy(@Json(name = "content") RepresentationContentDTO content, @Json(name = BoxRepresentation.FIELD_INFO) RepresentationInfoDTO info, @Json(name = "properties") RepresentationPropertiesDTO properties, @Json(name = BoxRepresentation.FIELD_REPRESENTATION) RepresentationTypeDTO representationType, @Json(name = "status") RepresentationStatusDTO status) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(representationType, "representationType");
        Intrinsics.checkNotNullParameter(status, "status");
        return new RepresentationDTO(content, info, properties, representationType, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepresentationDTO)) {
            return false;
        }
        RepresentationDTO representationDTO = (RepresentationDTO) other;
        return Intrinsics.areEqual(this.content, representationDTO.content) && Intrinsics.areEqual(this.info, representationDTO.info) && Intrinsics.areEqual(this.properties, representationDTO.properties) && this.representationType == representationDTO.representationType && Intrinsics.areEqual(this.status, representationDTO.status);
    }

    public int hashCode() {
        int iHashCode = this.content.hashCode() * 31;
        RepresentationInfoDTO representationInfoDTO = this.info;
        return ((((((iHashCode + (representationInfoDTO == null ? 0 : representationInfoDTO.hashCode())) * 31) + this.properties.hashCode()) * 31) + this.representationType.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "RepresentationDTO(content=" + this.content + ", info=" + this.info + ", properties=" + this.properties + ", representationType=" + this.representationType + ", status=" + this.status + ")";
    }

    public RepresentationDTO(@Json(name = "content") RepresentationContentDTO content, @Json(name = BoxRepresentation.FIELD_INFO) RepresentationInfoDTO representationInfoDTO, @Json(name = "properties") RepresentationPropertiesDTO properties, @Json(name = BoxRepresentation.FIELD_REPRESENTATION) RepresentationTypeDTO representationType, @Json(name = "status") RepresentationStatusDTO status) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(representationType, "representationType");
        Intrinsics.checkNotNullParameter(status, "status");
        this.content = content;
        this.info = representationInfoDTO;
        this.properties = properties;
        this.representationType = representationType;
        this.status = status;
    }

    public final RepresentationContentDTO getContent() {
        return this.content;
    }

    public final RepresentationInfoDTO getInfo() {
        return this.info;
    }

    public final RepresentationPropertiesDTO getProperties() {
        return this.properties;
    }

    public final RepresentationTypeDTO getRepresentationType() {
        return this.representationType;
    }

    public final RepresentationStatusDTO getStatus() {
        return this.status;
    }
}
