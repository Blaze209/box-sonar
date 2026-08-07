package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxUploadSessionPart;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChunkedFileUploadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "", "id", "", "offset", "", "size", "sha1", "<init>", "(Ljava/lang/String;JJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getOffset", "()J", "getSize", "getSha1", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadFileChunkDTO {
    private final String id;
    private final long offset;
    private final String sha1;
    private final long size;

    public static /* synthetic */ UploadFileChunkDTO copy$default(UploadFileChunkDTO uploadFileChunkDTO, String str, long j, long j2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadFileChunkDTO.id;
        }
        if ((i & 2) != 0) {
            j = uploadFileChunkDTO.offset;
        }
        if ((i & 4) != 0) {
            j2 = uploadFileChunkDTO.size;
        }
        if ((i & 8) != 0) {
            str2 = uploadFileChunkDTO.sha1;
        }
        String str3 = str2;
        return uploadFileChunkDTO.copy(str, j, j2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    public final UploadFileChunkDTO copy(@Json(name = BoxUploadSessionPart.FIELD_PART_ID) String id, @Json(name = "offset") long offset, @Json(name = "size") long size, @Json(name = "sha1") String sha1) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        return new UploadFileChunkDTO(id, offset, size, sha1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadFileChunkDTO)) {
            return false;
        }
        UploadFileChunkDTO uploadFileChunkDTO = (UploadFileChunkDTO) other;
        return Intrinsics.areEqual(this.id, uploadFileChunkDTO.id) && this.offset == uploadFileChunkDTO.offset && this.size == uploadFileChunkDTO.size && Intrinsics.areEqual(this.sha1, uploadFileChunkDTO.sha1);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + Long.hashCode(this.offset)) * 31) + Long.hashCode(this.size)) * 31) + this.sha1.hashCode();
    }

    public String toString() {
        return "UploadFileChunkDTO(id=" + this.id + ", offset=" + this.offset + ", size=" + this.size + ", sha1=" + this.sha1 + ")";
    }

    public UploadFileChunkDTO(@Json(name = BoxUploadSessionPart.FIELD_PART_ID) String id, @Json(name = "offset") long j, @Json(name = "size") long j2, @Json(name = "sha1") String sha1) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        this.id = id;
        this.offset = j;
        this.size = j2;
        this.sha1 = sha1;
    }

    public final String getId() {
        return this.id;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getSha1() {
        return this.sha1;
    }
}
