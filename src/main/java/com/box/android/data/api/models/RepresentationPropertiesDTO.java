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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/api/models/RepresentationPropertiesDTO;", "", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS, "", "isPaged", "isThumbnail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDimensions", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationPropertiesDTO {
    private final String dimensions;
    private final String isPaged;
    private final String isThumbnail;

    public static /* synthetic */ RepresentationPropertiesDTO copy$default(RepresentationPropertiesDTO representationPropertiesDTO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = representationPropertiesDTO.dimensions;
        }
        if ((i & 2) != 0) {
            str2 = representationPropertiesDTO.isPaged;
        }
        if ((i & 4) != 0) {
            str3 = representationPropertiesDTO.isThumbnail;
        }
        return representationPropertiesDTO.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDimensions() {
        return this.dimensions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIsPaged() {
        return this.isPaged;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIsThumbnail() {
        return this.isThumbnail;
    }

    public final RepresentationPropertiesDTO copy(@Json(name = BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS) String dimensions, @Json(name = BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_PAGED) String isPaged, @Json(name = BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_THUMB) String isThumbnail) {
        return new RepresentationPropertiesDTO(dimensions, isPaged, isThumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepresentationPropertiesDTO)) {
            return false;
        }
        RepresentationPropertiesDTO representationPropertiesDTO = (RepresentationPropertiesDTO) other;
        return Intrinsics.areEqual(this.dimensions, representationPropertiesDTO.dimensions) && Intrinsics.areEqual(this.isPaged, representationPropertiesDTO.isPaged) && Intrinsics.areEqual(this.isThumbnail, representationPropertiesDTO.isThumbnail);
    }

    public int hashCode() {
        String str = this.dimensions;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.isPaged;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.isThumbnail;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "RepresentationPropertiesDTO(dimensions=" + this.dimensions + ", isPaged=" + this.isPaged + ", isThumbnail=" + this.isThumbnail + ")";
    }

    public RepresentationPropertiesDTO(@Json(name = BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS) String str, @Json(name = BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_PAGED) String str2, @Json(name = BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_THUMB) String str3) {
        this.dimensions = str;
        this.isPaged = str2;
        this.isThumbnail = str3;
    }

    public final String getDimensions() {
        return this.dimensions;
    }

    public final String isPaged() {
        return this.isPaged;
    }

    public final String isThumbnail() {
        return this.isThumbnail;
    }
}
