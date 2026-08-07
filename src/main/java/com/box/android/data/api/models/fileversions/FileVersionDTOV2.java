package com.box.android.data.api.models.fileversions;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxFile;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionDTOV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JR\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/box/android/data/api/models/fileversions/FileVersionDTOV2;", "", "id", "", "name", "number", "", "createdAt", "Ljava/util/Date;", "modifiedAt", "modifiedBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/api/models/UserMiniDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedAt", "()Ljava/util/Date;", "getModifiedAt", "getModifiedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/api/models/UserMiniDTO;)Lcom/box/android/data/api/models/fileversions/FileVersionDTOV2;", "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionDTOV2 {
    private final Date createdAt;
    private final String id;
    private final Date modifiedAt;
    private final UserMiniDTO modifiedBy;
    private final String name;
    private final Integer number;

    public static /* synthetic */ FileVersionDTOV2 copy$default(FileVersionDTOV2 fileVersionDTOV2, String str, String str2, Integer num, Date date, Date date2, UserMiniDTO userMiniDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileVersionDTOV2.id;
        }
        if ((i & 2) != 0) {
            str2 = fileVersionDTOV2.name;
        }
        if ((i & 4) != 0) {
            num = fileVersionDTOV2.number;
        }
        if ((i & 8) != 0) {
            date = fileVersionDTOV2.createdAt;
        }
        if ((i & 16) != 0) {
            date2 = fileVersionDTOV2.modifiedAt;
        }
        if ((i & 32) != 0) {
            userMiniDTO = fileVersionDTOV2.modifiedBy;
        }
        Date date3 = date2;
        UserMiniDTO userMiniDTO2 = userMiniDTO;
        return fileVersionDTOV2.copy(str, str2, num, date, date3, userMiniDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getNumber() {
        return this.number;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    public final FileVersionDTOV2 copy(@Json(name = "id") String id, @Json(name = "name") String name, @Json(name = BoxFile.FIELD_VERSION_NUMBER) Integer number, @Json(name = "created_at") Date createdAt, @Json(name = "modified_at") Date modifiedAt, @Json(name = "modified_by") UserMiniDTO modifiedBy) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new FileVersionDTOV2(id, name, number, createdAt, modifiedAt, modifiedBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionDTOV2)) {
            return false;
        }
        FileVersionDTOV2 fileVersionDTOV2 = (FileVersionDTOV2) other;
        return Intrinsics.areEqual(this.id, fileVersionDTOV2.id) && Intrinsics.areEqual(this.name, fileVersionDTOV2.name) && Intrinsics.areEqual(this.number, fileVersionDTOV2.number) && Intrinsics.areEqual(this.createdAt, fileVersionDTOV2.createdAt) && Intrinsics.areEqual(this.modifiedAt, fileVersionDTOV2.modifiedAt) && Intrinsics.areEqual(this.modifiedBy, fileVersionDTOV2.modifiedBy);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.number;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.createdAt.hashCode()) * 31;
        Date date = this.modifiedAt;
        int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
        UserMiniDTO userMiniDTO = this.modifiedBy;
        return iHashCode4 + (userMiniDTO != null ? userMiniDTO.hashCode() : 0);
    }

    public String toString() {
        return "FileVersionDTOV2(id=" + this.id + ", name=" + this.name + ", number=" + this.number + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", modifiedBy=" + this.modifiedBy + ")";
    }

    public FileVersionDTOV2(@Json(name = "id") String id, @Json(name = "name") String str, @Json(name = BoxFile.FIELD_VERSION_NUMBER) Integer num, @Json(name = "created_at") Date createdAt, @Json(name = "modified_at") Date date, @Json(name = "modified_by") UserMiniDTO userMiniDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = id;
        this.name = str;
        this.number = num;
        this.createdAt = createdAt;
        this.modifiedAt = date;
        this.modifiedBy = userMiniDTO;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getNumber() {
        return this.number;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }
}
