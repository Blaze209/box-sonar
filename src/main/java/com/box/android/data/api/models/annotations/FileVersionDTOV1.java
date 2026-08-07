package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0016\u001a\u00020\bHÆ\u0003J:\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;", "", "id", "", "name", "number", "", "createdAt", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;)V", "getId", "()Ljava/lang/String;", "getName", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedAt", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;)Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;", "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionDTOV1 {
    private final Date createdAt;
    private final String id;
    private final String name;
    private final Integer number;

    public static /* synthetic */ FileVersionDTOV1 copy$default(FileVersionDTOV1 fileVersionDTOV1, String str, String str2, Integer num, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileVersionDTOV1.id;
        }
        if ((i & 2) != 0) {
            str2 = fileVersionDTOV1.name;
        }
        if ((i & 4) != 0) {
            num = fileVersionDTOV1.number;
        }
        if ((i & 8) != 0) {
            date = fileVersionDTOV1.createdAt;
        }
        return fileVersionDTOV1.copy(str, str2, num, date);
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

    public final FileVersionDTOV1 copy(@Json(name = "id") String id, @Json(name = "name") String name, @Json(name = "number") Integer number, @Json(name = "created_at") Date createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new FileVersionDTOV1(id, name, number, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionDTOV1)) {
            return false;
        }
        FileVersionDTOV1 fileVersionDTOV1 = (FileVersionDTOV1) other;
        return Intrinsics.areEqual(this.id, fileVersionDTOV1.id) && Intrinsics.areEqual(this.name, fileVersionDTOV1.name) && Intrinsics.areEqual(this.number, fileVersionDTOV1.number) && Intrinsics.areEqual(this.createdAt, fileVersionDTOV1.createdAt);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.number;
        return ((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.createdAt.hashCode();
    }

    public String toString() {
        return "FileVersionDTOV1(id=" + this.id + ", name=" + this.name + ", number=" + this.number + ", createdAt=" + this.createdAt + ")";
    }

    public FileVersionDTOV1(@Json(name = "id") String id, @Json(name = "name") String str, @Json(name = "number") Integer num, @Json(name = "created_at") Date createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = id;
        this.name = str;
        this.number = num;
        this.createdAt = createdAt;
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
}
