package com.box.android.data.api.models.annotations;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/api/models/annotations/VersionsDTO;", "", "createdBy", "", "Lcom/box/android/data/api/models/UserMiniDTO;", "start", "Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;", "end", "<init>", "(Ljava/util/List;Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;)V", "getCreatedBy", "()Ljava/util/List;", "getStart", "()Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;", "getEnd", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VersionsDTO {
    private final List<UserMiniDTO> createdBy;
    private final FileVersionDTOV1 end;
    private final FileVersionDTOV1 start;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VersionsDTO copy$default(VersionsDTO versionsDTO, List list, FileVersionDTOV1 fileVersionDTOV1, FileVersionDTOV1 fileVersionDTOV2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = versionsDTO.createdBy;
        }
        if ((i & 2) != 0) {
            fileVersionDTOV1 = versionsDTO.start;
        }
        if ((i & 4) != 0) {
            fileVersionDTOV2 = versionsDTO.end;
        }
        return versionsDTO.copy(list, fileVersionDTOV1, fileVersionDTOV2);
    }

    public final List<UserMiniDTO> component1() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileVersionDTOV1 getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FileVersionDTOV1 getEnd() {
        return this.end;
    }

    public final VersionsDTO copy(@Json(name = "created_by") List<UserMiniDTO> createdBy, @Json(name = "start") FileVersionDTOV1 start, @Json(name = "end") FileVersionDTOV1 end) {
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new VersionsDTO(createdBy, start, end);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VersionsDTO)) {
            return false;
        }
        VersionsDTO versionsDTO = (VersionsDTO) other;
        return Intrinsics.areEqual(this.createdBy, versionsDTO.createdBy) && Intrinsics.areEqual(this.start, versionsDTO.start) && Intrinsics.areEqual(this.end, versionsDTO.end);
    }

    public int hashCode() {
        return (((this.createdBy.hashCode() * 31) + this.start.hashCode()) * 31) + this.end.hashCode();
    }

    public String toString() {
        return "VersionsDTO(createdBy=" + this.createdBy + ", start=" + this.start + ", end=" + this.end + ")";
    }

    public VersionsDTO(@Json(name = "created_by") List<UserMiniDTO> createdBy, @Json(name = "start") FileVersionDTOV1 start, @Json(name = "end") FileVersionDTOV1 end) {
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.createdBy = createdBy;
        this.start = start;
        this.end = end;
    }

    public final List<UserMiniDTO> getCreatedBy() {
        return this.createdBy;
    }

    public final FileVersionDTOV1 getStart() {
        return this.start;
    }

    public final FileVersionDTOV1 getEnd() {
        return this.end;
    }
}
