package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileLockDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J^\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\n\u0010\u0016¨\u0006&"}, d2 = {"Lcom/box/android/data/api/models/FileLockDTO;", "", "id", "", "type", "appType", "createdAt", "createdBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "expiresAt", "isDownloadPrevented", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "getAppType", "getCreatedAt", "getCreatedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getExpiresAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/FileLockDTO;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileLockDTO {
    private final String appType;
    private final String createdAt;
    private final UserMiniDTO createdBy;
    private final String expiresAt;
    private final String id;
    private final Boolean isDownloadPrevented;
    private final String type;

    public static /* synthetic */ FileLockDTO copy$default(FileLockDTO fileLockDTO, String str, String str2, String str3, String str4, UserMiniDTO userMiniDTO, String str5, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileLockDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = fileLockDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = fileLockDTO.appType;
        }
        if ((i & 8) != 0) {
            str4 = fileLockDTO.createdAt;
        }
        if ((i & 16) != 0) {
            userMiniDTO = fileLockDTO.createdBy;
        }
        if ((i & 32) != 0) {
            str5 = fileLockDTO.expiresAt;
        }
        if ((i & 64) != 0) {
            bool = fileLockDTO.isDownloadPrevented;
        }
        String str6 = str5;
        Boolean bool2 = bool;
        UserMiniDTO userMiniDTO2 = userMiniDTO;
        String str7 = str3;
        return fileLockDTO.copy(str, str2, str7, str4, userMiniDTO2, str6, bool2);
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
    public final String getAppType() {
        return this.appType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getIsDownloadPrevented() {
        return this.isDownloadPrevented;
    }

    public final FileLockDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "app_type") String appType, @Json(name = "created_at") String createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = BoxCollaboration.FIELD_EXPIRES_AT) String expiresAt, @Json(name = "is_download_prevented") Boolean isDownloadPrevented) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FileLockDTO(id, type, appType, createdAt, createdBy, expiresAt, isDownloadPrevented);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileLockDTO)) {
            return false;
        }
        FileLockDTO fileLockDTO = (FileLockDTO) other;
        return Intrinsics.areEqual(this.id, fileLockDTO.id) && Intrinsics.areEqual(this.type, fileLockDTO.type) && Intrinsics.areEqual(this.appType, fileLockDTO.appType) && Intrinsics.areEqual(this.createdAt, fileLockDTO.createdAt) && Intrinsics.areEqual(this.createdBy, fileLockDTO.createdBy) && Intrinsics.areEqual(this.expiresAt, fileLockDTO.expiresAt) && Intrinsics.areEqual(this.isDownloadPrevented, fileLockDTO.isDownloadPrevented);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.appType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.createdAt;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        UserMiniDTO userMiniDTO = this.createdBy;
        int iHashCode4 = (iHashCode3 + (userMiniDTO == null ? 0 : userMiniDTO.hashCode())) * 31;
        String str3 = this.expiresAt;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isDownloadPrevented;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "FileLockDTO(id=" + this.id + ", type=" + this.type + ", appType=" + this.appType + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", expiresAt=" + this.expiresAt + ", isDownloadPrevented=" + this.isDownloadPrevented + ")";
    }

    public FileLockDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "app_type") String str, @Json(name = "created_at") String str2, @Json(name = "created_by") UserMiniDTO userMiniDTO, @Json(name = BoxCollaboration.FIELD_EXPIRES_AT) String str3, @Json(name = "is_download_prevented") Boolean bool) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.appType = str;
        this.createdAt = str2;
        this.createdBy = userMiniDTO;
        this.expiresAt = str3;
        this.isDownloadPrevented = bool;
    }

    public /* synthetic */ FileLockDTO(String str, String str2, String str3, String str4, UserMiniDTO userMiniDTO, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : userMiniDTO, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool);
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAppType() {
        return this.appType;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final Boolean isDownloadPrevented() {
        return this.isDownloadPrevented;
    }
}
