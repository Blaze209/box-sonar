package com.box.android.data.api.models.upload;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadSessionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadSessionArgsDTO;", "", "parentFolderId", "", BoxCommonConstants.EXTRA_FILE_NAME, "fileSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getParentFolderId", "()Ljava/lang/String;", "getFileName", "getFileSize", "()J", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadSessionArgsDTO {
    private final String fileName;
    private final long fileSize;
    private final String parentFolderId;

    public static /* synthetic */ UploadSessionArgsDTO copy$default(UploadSessionArgsDTO uploadSessionArgsDTO, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadSessionArgsDTO.parentFolderId;
        }
        if ((i & 2) != 0) {
            str2 = uploadSessionArgsDTO.fileName;
        }
        if ((i & 4) != 0) {
            j = uploadSessionArgsDTO.fileSize;
        }
        return uploadSessionArgsDTO.copy(str, str2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getParentFolderId() {
        return this.parentFolderId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    public final UploadSessionArgsDTO copy(@Json(name = "folder_id") String parentFolderId, @Json(name = BoxRequestCreateBoxNote.FIELD_FILE_NAME) String fileName, @Json(name = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE) long fileSize) {
        return new UploadSessionArgsDTO(parentFolderId, fileName, fileSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadSessionArgsDTO)) {
            return false;
        }
        UploadSessionArgsDTO uploadSessionArgsDTO = (UploadSessionArgsDTO) other;
        return Intrinsics.areEqual(this.parentFolderId, uploadSessionArgsDTO.parentFolderId) && Intrinsics.areEqual(this.fileName, uploadSessionArgsDTO.fileName) && this.fileSize == uploadSessionArgsDTO.fileSize;
    }

    public int hashCode() {
        String str = this.parentFolderId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileName;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.fileSize);
    }

    public String toString() {
        return "UploadSessionArgsDTO(parentFolderId=" + this.parentFolderId + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ")";
    }

    public UploadSessionArgsDTO(@Json(name = "folder_id") String str, @Json(name = BoxRequestCreateBoxNote.FIELD_FILE_NAME) String str2, @Json(name = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE) long j) {
        this.parentFolderId = str;
        this.fileName = str2;
        this.fileSize = j;
    }

    public final String getParentFolderId() {
        return this.parentFolderId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }
}
