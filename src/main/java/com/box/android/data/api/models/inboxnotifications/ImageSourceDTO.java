package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/ImageSourceDTO;", "", "name", "", "nameDark", "url", "urlDark", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNameDark", "getUrl", "getUrlDark", "getType", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageSourceDTO {
    private final String name;
    private final String nameDark;
    private final String type;
    private final String url;
    private final String urlDark;

    public static /* synthetic */ ImageSourceDTO copy$default(ImageSourceDTO imageSourceDTO, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageSourceDTO.name;
        }
        if ((i & 2) != 0) {
            str2 = imageSourceDTO.nameDark;
        }
        if ((i & 4) != 0) {
            str3 = imageSourceDTO.url;
        }
        if ((i & 8) != 0) {
            str4 = imageSourceDTO.urlDark;
        }
        if ((i & 16) != 0) {
            str5 = imageSourceDTO.type;
        }
        String str6 = str5;
        String str7 = str3;
        return imageSourceDTO.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNameDark() {
        return this.nameDark;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrlDark() {
        return this.urlDark;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ImageSourceDTO copy(@Json(name = "name") String name, @Json(name = "name_dark") String nameDark, @Json(name = "url") String url, @Json(name = "url_dark") String urlDark, @Json(name = "type") String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ImageSourceDTO(name, nameDark, url, urlDark, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageSourceDTO)) {
            return false;
        }
        ImageSourceDTO imageSourceDTO = (ImageSourceDTO) other;
        return Intrinsics.areEqual(this.name, imageSourceDTO.name) && Intrinsics.areEqual(this.nameDark, imageSourceDTO.nameDark) && Intrinsics.areEqual(this.url, imageSourceDTO.url) && Intrinsics.areEqual(this.urlDark, imageSourceDTO.urlDark) && Intrinsics.areEqual(this.type, imageSourceDTO.type);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.nameDark;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.urlDark;
        return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ImageSourceDTO(name=" + this.name + ", nameDark=" + this.nameDark + ", url=" + this.url + ", urlDark=" + this.urlDark + ", type=" + this.type + ")";
    }

    public ImageSourceDTO(@Json(name = "name") String name, @Json(name = "name_dark") String str, @Json(name = "url") String str2, @Json(name = "url_dark") String str3, @Json(name = "type") String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.nameDark = str;
        this.url = str2;
        this.urlDark = str3;
        this.type = type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameDark() {
        return this.nameDark;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlDark() {
        return this.urlDark;
    }

    public final String getType() {
        return this.type;
    }
}
