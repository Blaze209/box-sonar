package com.box.android.data.api.models.fileversions;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionMiniDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "", "id", "", "type", "sha1", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "getSha1", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionMiniDTO {
    private final String id;
    private final String sha1;
    private final String type;

    public static /* synthetic */ FileVersionMiniDTO copy$default(FileVersionMiniDTO fileVersionMiniDTO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileVersionMiniDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = fileVersionMiniDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = fileVersionMiniDTO.sha1;
        }
        return fileVersionMiniDTO.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    public final FileVersionMiniDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "sha1") String sha1) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        return new FileVersionMiniDTO(id, type, sha1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionMiniDTO)) {
            return false;
        }
        FileVersionMiniDTO fileVersionMiniDTO = (FileVersionMiniDTO) other;
        return Intrinsics.areEqual(this.id, fileVersionMiniDTO.id) && Intrinsics.areEqual(this.type, fileVersionMiniDTO.type) && Intrinsics.areEqual(this.sha1, fileVersionMiniDTO.sha1);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.sha1.hashCode();
    }

    public String toString() {
        return "FileVersionMiniDTO(id=" + this.id + ", type=" + this.type + ", sha1=" + this.sha1 + ")";
    }

    public FileVersionMiniDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "sha1") String sha1) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        this.id = id;
        this.type = type;
        this.sha1 = sha1;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSha1() {
        return this.sha1;
    }
}
