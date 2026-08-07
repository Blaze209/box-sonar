package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "", "type", "", "alt", "tooltip", "imageSource", "Lcom/box/android/data/api/models/inboxnotifications/ImageSourceDTO;", "borderImageSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/ImageSourceDTO;Lcom/box/android/data/api/models/inboxnotifications/ImageSourceDTO;)V", "getType", "()Ljava/lang/String;", "getAlt", "getTooltip", "getImageSource", "()Lcom/box/android/data/api/models/inboxnotifications/ImageSourceDTO;", "getBorderImageSource", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class IconDTO {
    private final String alt;
    private final ImageSourceDTO borderImageSource;
    private final ImageSourceDTO imageSource;
    private final String tooltip;
    private final String type;

    public static /* synthetic */ IconDTO copy$default(IconDTO iconDTO, String str, String str2, String str3, ImageSourceDTO imageSourceDTO, ImageSourceDTO imageSourceDTO2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iconDTO.type;
        }
        if ((i & 2) != 0) {
            str2 = iconDTO.alt;
        }
        if ((i & 4) != 0) {
            str3 = iconDTO.tooltip;
        }
        if ((i & 8) != 0) {
            imageSourceDTO = iconDTO.imageSource;
        }
        if ((i & 16) != 0) {
            imageSourceDTO2 = iconDTO.borderImageSource;
        }
        ImageSourceDTO imageSourceDTO3 = imageSourceDTO2;
        String str4 = str3;
        return iconDTO.copy(str, str2, str4, imageSourceDTO, imageSourceDTO3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlt() {
        return this.alt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTooltip() {
        return this.tooltip;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ImageSourceDTO getImageSource() {
        return this.imageSource;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ImageSourceDTO getBorderImageSource() {
        return this.borderImageSource;
    }

    public final IconDTO copy(@Json(name = "type") String type, @Json(name = "alt") String alt, @Json(name = "tooltip") String tooltip, @Json(name = "image_source") ImageSourceDTO imageSource, @Json(name = "border_image_source") ImageSourceDTO borderImageSource) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        return new IconDTO(type, alt, tooltip, imageSource, borderImageSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconDTO)) {
            return false;
        }
        IconDTO iconDTO = (IconDTO) other;
        return Intrinsics.areEqual(this.type, iconDTO.type) && Intrinsics.areEqual(this.alt, iconDTO.alt) && Intrinsics.areEqual(this.tooltip, iconDTO.tooltip) && Intrinsics.areEqual(this.imageSource, iconDTO.imageSource) && Intrinsics.areEqual(this.borderImageSource, iconDTO.borderImageSource);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.alt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tooltip;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.imageSource.hashCode()) * 31;
        ImageSourceDTO imageSourceDTO = this.borderImageSource;
        return iHashCode3 + (imageSourceDTO != null ? imageSourceDTO.hashCode() : 0);
    }

    public String toString() {
        return "IconDTO(type=" + this.type + ", alt=" + this.alt + ", tooltip=" + this.tooltip + ", imageSource=" + this.imageSource + ", borderImageSource=" + this.borderImageSource + ")";
    }

    public IconDTO(@Json(name = "type") String type, @Json(name = "alt") String str, @Json(name = "tooltip") String str2, @Json(name = "image_source") ImageSourceDTO imageSource, @Json(name = "border_image_source") ImageSourceDTO imageSourceDTO) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        this.type = type;
        this.alt = str;
        this.tooltip = str2;
        this.imageSource = imageSource;
        this.borderImageSource = imageSourceDTO;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAlt() {
        return this.alt;
    }

    public final String getTooltip() {
        return this.tooltip;
    }

    public final ImageSourceDTO getImageSource() {
        return this.imageSource;
    }

    public final ImageSourceDTO getBorderImageSource() {
        return this.borderImageSource;
    }
}
