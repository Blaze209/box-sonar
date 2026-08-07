package com.box.android.data.api.models.annotations;

import com.box.android.data.api.models.ErrorDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityFetchErrorDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityFetchErrorDTO;", "", "activityType", "", "id", "error", "Lcom/box/android/data/api/models/ErrorDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/ErrorDTO;)V", "getActivityType", "()Ljava/lang/String;", "getId", "getError", "()Lcom/box/android/data/api/models/ErrorDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityFetchErrorDTO {
    private final String activityType;
    private final ErrorDTO error;
    private final String id;

    public static /* synthetic */ FileActivityFetchErrorDTO copy$default(FileActivityFetchErrorDTO fileActivityFetchErrorDTO, String str, String str2, ErrorDTO errorDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileActivityFetchErrorDTO.activityType;
        }
        if ((i & 2) != 0) {
            str2 = fileActivityFetchErrorDTO.id;
        }
        if ((i & 4) != 0) {
            errorDTO = fileActivityFetchErrorDTO.error;
        }
        return fileActivityFetchErrorDTO.copy(str, str2, errorDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityType() {
        return this.activityType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ErrorDTO getError() {
        return this.error;
    }

    public final FileActivityFetchErrorDTO copy(@Json(name = "activity_type") String activityType, @Json(name = "id") String id, @Json(name = "error") ErrorDTO error) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(error, "error");
        return new FileActivityFetchErrorDTO(activityType, id, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityFetchErrorDTO)) {
            return false;
        }
        FileActivityFetchErrorDTO fileActivityFetchErrorDTO = (FileActivityFetchErrorDTO) other;
        return Intrinsics.areEqual(this.activityType, fileActivityFetchErrorDTO.activityType) && Intrinsics.areEqual(this.id, fileActivityFetchErrorDTO.id) && Intrinsics.areEqual(this.error, fileActivityFetchErrorDTO.error);
    }

    public int hashCode() {
        int iHashCode = this.activityType.hashCode() * 31;
        String str = this.id;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "FileActivityFetchErrorDTO(activityType=" + this.activityType + ", id=" + this.id + ", error=" + this.error + ")";
    }

    public FileActivityFetchErrorDTO(@Json(name = "activity_type") String activityType, @Json(name = "id") String str, @Json(name = "error") ErrorDTO error) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(error, "error");
        this.activityType = activityType;
        this.id = str;
        this.error = error;
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final String getId() {
        return this.id;
    }

    public final ErrorDTO getError() {
        return this.error;
    }
}
