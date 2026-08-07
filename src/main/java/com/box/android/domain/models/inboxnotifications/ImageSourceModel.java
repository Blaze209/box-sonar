package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/ImageSourceModel;", "Lcom/box/android/domain/models/DomainModel;", "name", "", "nameDark", "url", "urlDark", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNameDark", "getUrl", "getUrlDark", "getType", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageSourceModel implements DomainModel {
    private final String name;
    private final String nameDark;
    private final String type;
    private final String url;
    private final String urlDark;

    public static /* synthetic */ ImageSourceModel copy$default(ImageSourceModel imageSourceModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageSourceModel.name;
        }
        if ((i & 2) != 0) {
            str2 = imageSourceModel.nameDark;
        }
        if ((i & 4) != 0) {
            str3 = imageSourceModel.url;
        }
        if ((i & 8) != 0) {
            str4 = imageSourceModel.urlDark;
        }
        if ((i & 16) != 0) {
            str5 = imageSourceModel.type;
        }
        String str6 = str5;
        String str7 = str3;
        return imageSourceModel.copy(str, str2, str7, str4, str6);
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

    public final ImageSourceModel copy(String name, String nameDark, String url, String urlDark, String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ImageSourceModel(name, nameDark, url, urlDark, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageSourceModel)) {
            return false;
        }
        ImageSourceModel imageSourceModel = (ImageSourceModel) other;
        return Intrinsics.areEqual(this.name, imageSourceModel.name) && Intrinsics.areEqual(this.nameDark, imageSourceModel.nameDark) && Intrinsics.areEqual(this.url, imageSourceModel.url) && Intrinsics.areEqual(this.urlDark, imageSourceModel.urlDark) && Intrinsics.areEqual(this.type, imageSourceModel.type);
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
        return "ImageSourceModel(name=" + this.name + ", nameDark=" + this.nameDark + ", url=" + this.url + ", urlDark=" + this.urlDark + ", type=" + this.type + ")";
    }

    public ImageSourceModel(String name, String str, String str2, String str3, String type) {
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
