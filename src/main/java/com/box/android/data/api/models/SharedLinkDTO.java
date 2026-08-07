package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u0010.\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\t\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Lcom/box/android/data/api/models/SharedLinkDTO;", "", "access", "", "downloadCount", "", "downloadUrl", "vanityUrl", "effectivePermission", "isPasswordEnabled", "", "permissions", "Lcom/box/android/data/api/models/SharedLinkPermissionsDTO;", "effectiveAccess", "previewCount", "unsharedAt", "url", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/box/android/data/api/models/SharedLinkPermissionsDTO;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAccess", "()Ljava/lang/String;", "getDownloadCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDownloadUrl", "getVanityUrl", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPermissions", "()Lcom/box/android/data/api/models/SharedLinkPermissionsDTO;", "getEffectiveAccess", "getPreviewCount", "getUnsharedAt", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/box/android/data/api/models/SharedLinkPermissionsDTO;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/data/api/models/SharedLinkDTO;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SharedLinkDTO {
    private final String access;
    private final Long downloadCount;
    private final String downloadUrl;
    private final String effectiveAccess;
    private final String effectivePermission;
    private final Boolean isPasswordEnabled;
    private final SharedLinkPermissionsDTO permissions;
    private final Long previewCount;
    private final String unsharedAt;
    private final String url;
    private final String vanityUrl;

    public SharedLinkDTO() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ SharedLinkDTO copy$default(SharedLinkDTO sharedLinkDTO, String str, Long l, String str2, String str3, String str4, Boolean bool, SharedLinkPermissionsDTO sharedLinkPermissionsDTO, String str5, Long l2, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharedLinkDTO.access;
        }
        if ((i & 2) != 0) {
            l = sharedLinkDTO.downloadCount;
        }
        if ((i & 4) != 0) {
            str2 = sharedLinkDTO.downloadUrl;
        }
        if ((i & 8) != 0) {
            str3 = sharedLinkDTO.vanityUrl;
        }
        if ((i & 16) != 0) {
            str4 = sharedLinkDTO.effectivePermission;
        }
        if ((i & 32) != 0) {
            bool = sharedLinkDTO.isPasswordEnabled;
        }
        if ((i & 64) != 0) {
            sharedLinkPermissionsDTO = sharedLinkDTO.permissions;
        }
        if ((i & 128) != 0) {
            str5 = sharedLinkDTO.effectiveAccess;
        }
        if ((i & 256) != 0) {
            l2 = sharedLinkDTO.previewCount;
        }
        if ((i & 512) != 0) {
            str6 = sharedLinkDTO.unsharedAt;
        }
        if ((i & 1024) != 0) {
            str7 = sharedLinkDTO.url;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        Long l3 = l2;
        Boolean bool2 = bool;
        SharedLinkPermissionsDTO sharedLinkPermissionsDTO2 = sharedLinkPermissionsDTO;
        String str11 = str4;
        String str12 = str2;
        return sharedLinkDTO.copy(str, l, str12, str3, str11, bool2, sharedLinkPermissionsDTO2, str10, l3, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccess() {
        return this.access;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getUnsharedAt() {
        return this.unsharedAt;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getDownloadCount() {
        return this.downloadCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVanityUrl() {
        return this.vanityUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEffectivePermission() {
        return this.effectivePermission;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsPasswordEnabled() {
        return this.isPasswordEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SharedLinkPermissionsDTO getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getEffectiveAccess() {
        return this.effectiveAccess;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getPreviewCount() {
        return this.previewCount;
    }

    public final SharedLinkDTO copy(@Json(name = "access") String access, @Json(name = BoxSharedLink.FIELD_DOWNLOAD_COUNT) Long downloadCount, @Json(name = BoxSharedLink.FIELD_DOWNLOAD_URL) String downloadUrl, @Json(name = BoxSharedLink.FIELD_VANITY_URL) String vanityUrl, @Json(name = BoxSharedLink.FIELD_EFFECTIVE_PERMISSION) String effectivePermission, @Json(name = BoxSharedLink.FIELD_IS_PASSWORD_ENABLED) Boolean isPasswordEnabled, @Json(name = "permissions") SharedLinkPermissionsDTO permissions, @Json(name = BoxSharedLink.FIELD_EFFECTIVE_ACCESS) String effectiveAccess, @Json(name = BoxSharedLink.FIELD_PREVIEW_COUNT) Long previewCount, @Json(name = BoxSharedLink.FIELD_UNSHARED_AT) String unsharedAt, @Json(name = "url") String url) {
        return new SharedLinkDTO(access, downloadCount, downloadUrl, vanityUrl, effectivePermission, isPasswordEnabled, permissions, effectiveAccess, previewCount, unsharedAt, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharedLinkDTO)) {
            return false;
        }
        SharedLinkDTO sharedLinkDTO = (SharedLinkDTO) other;
        return Intrinsics.areEqual(this.access, sharedLinkDTO.access) && Intrinsics.areEqual(this.downloadCount, sharedLinkDTO.downloadCount) && Intrinsics.areEqual(this.downloadUrl, sharedLinkDTO.downloadUrl) && Intrinsics.areEqual(this.vanityUrl, sharedLinkDTO.vanityUrl) && Intrinsics.areEqual(this.effectivePermission, sharedLinkDTO.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLinkDTO.isPasswordEnabled) && Intrinsics.areEqual(this.permissions, sharedLinkDTO.permissions) && Intrinsics.areEqual(this.effectiveAccess, sharedLinkDTO.effectiveAccess) && Intrinsics.areEqual(this.previewCount, sharedLinkDTO.previewCount) && Intrinsics.areEqual(this.unsharedAt, sharedLinkDTO.unsharedAt) && Intrinsics.areEqual(this.url, sharedLinkDTO.url);
    }

    public int hashCode() {
        String str = this.access;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.downloadCount;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.downloadUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vanityUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.effectivePermission;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isPasswordEnabled;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        SharedLinkPermissionsDTO sharedLinkPermissionsDTO = this.permissions;
        int iHashCode7 = (iHashCode6 + (sharedLinkPermissionsDTO == null ? 0 : sharedLinkPermissionsDTO.hashCode())) * 31;
        String str5 = this.effectiveAccess;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l2 = this.previewCount;
        int iHashCode9 = (iHashCode8 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str6 = this.unsharedAt;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.url;
        return iHashCode10 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "SharedLinkDTO(access=" + this.access + ", downloadCount=" + this.downloadCount + ", downloadUrl=" + this.downloadUrl + ", vanityUrl=" + this.vanityUrl + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", permissions=" + this.permissions + ", effectiveAccess=" + this.effectiveAccess + ", previewCount=" + this.previewCount + ", unsharedAt=" + this.unsharedAt + ", url=" + this.url + ")";
    }

    public SharedLinkDTO(@Json(name = "access") String str, @Json(name = BoxSharedLink.FIELD_DOWNLOAD_COUNT) Long l, @Json(name = BoxSharedLink.FIELD_DOWNLOAD_URL) String str2, @Json(name = BoxSharedLink.FIELD_VANITY_URL) String str3, @Json(name = BoxSharedLink.FIELD_EFFECTIVE_PERMISSION) String str4, @Json(name = BoxSharedLink.FIELD_IS_PASSWORD_ENABLED) Boolean bool, @Json(name = "permissions") SharedLinkPermissionsDTO sharedLinkPermissionsDTO, @Json(name = BoxSharedLink.FIELD_EFFECTIVE_ACCESS) String str5, @Json(name = BoxSharedLink.FIELD_PREVIEW_COUNT) Long l2, @Json(name = BoxSharedLink.FIELD_UNSHARED_AT) String str6, @Json(name = "url") String str7) {
        this.access = str;
        this.downloadCount = l;
        this.downloadUrl = str2;
        this.vanityUrl = str3;
        this.effectivePermission = str4;
        this.isPasswordEnabled = bool;
        this.permissions = sharedLinkPermissionsDTO;
        this.effectiveAccess = str5;
        this.previewCount = l2;
        this.unsharedAt = str6;
        this.url = str7;
    }

    public /* synthetic */ SharedLinkDTO(String str, Long l, String str2, String str3, String str4, Boolean bool, SharedLinkPermissionsDTO sharedLinkPermissionsDTO, String str5, Long l2, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : sharedLinkPermissionsDTO, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : l2, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7);
    }

    public final String getAccess() {
        return this.access;
    }

    public final Long getDownloadCount() {
        return this.downloadCount;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getVanityUrl() {
        return this.vanityUrl;
    }

    public final String getEffectivePermission() {
        return this.effectivePermission;
    }

    public final Boolean isPasswordEnabled() {
        return this.isPasswordEnabled;
    }

    public final SharedLinkPermissionsDTO getPermissions() {
        return this.permissions;
    }

    public final String getEffectiveAccess() {
        return this.effectiveAccess;
    }

    public final Long getPreviewCount() {
        return this.previewCount;
    }

    public final String getUnsharedAt() {
        return this.unsharedAt;
    }

    public final String getUrl() {
        return this.url;
    }
}
