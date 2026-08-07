package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/IconModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "", "alt", "tooltip", "imageSource", "Lcom/box/android/domain/models/inboxnotifications/ImageSourceModel;", "borderImageSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/ImageSourceModel;Lcom/box/android/domain/models/inboxnotifications/ImageSourceModel;)V", "getType", "()Ljava/lang/String;", "getAlt", "getTooltip", "getImageSource", "()Lcom/box/android/domain/models/inboxnotifications/ImageSourceModel;", "getBorderImageSource", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class IconModel implements DomainModel {
    private final String alt;
    private final ImageSourceModel borderImageSource;
    private final ImageSourceModel imageSource;
    private final String tooltip;
    private final String type;

    public static /* synthetic */ IconModel copy$default(IconModel iconModel, String str, String str2, String str3, ImageSourceModel imageSourceModel, ImageSourceModel imageSourceModel2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iconModel.type;
        }
        if ((i & 2) != 0) {
            str2 = iconModel.alt;
        }
        if ((i & 4) != 0) {
            str3 = iconModel.tooltip;
        }
        if ((i & 8) != 0) {
            imageSourceModel = iconModel.imageSource;
        }
        if ((i & 16) != 0) {
            imageSourceModel2 = iconModel.borderImageSource;
        }
        ImageSourceModel imageSourceModel3 = imageSourceModel2;
        String str4 = str3;
        return iconModel.copy(str, str2, str4, imageSourceModel, imageSourceModel3);
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
    public final ImageSourceModel getImageSource() {
        return this.imageSource;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ImageSourceModel getBorderImageSource() {
        return this.borderImageSource;
    }

    public final IconModel copy(String type, String alt, String tooltip, ImageSourceModel imageSource, ImageSourceModel borderImageSource) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        return new IconModel(type, alt, tooltip, imageSource, borderImageSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconModel)) {
            return false;
        }
        IconModel iconModel = (IconModel) other;
        return Intrinsics.areEqual(this.type, iconModel.type) && Intrinsics.areEqual(this.alt, iconModel.alt) && Intrinsics.areEqual(this.tooltip, iconModel.tooltip) && Intrinsics.areEqual(this.imageSource, iconModel.imageSource) && Intrinsics.areEqual(this.borderImageSource, iconModel.borderImageSource);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.alt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tooltip;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.imageSource.hashCode()) * 31;
        ImageSourceModel imageSourceModel = this.borderImageSource;
        return iHashCode3 + (imageSourceModel != null ? imageSourceModel.hashCode() : 0);
    }

    public String toString() {
        return "IconModel(type=" + this.type + ", alt=" + this.alt + ", tooltip=" + this.tooltip + ", imageSource=" + this.imageSource + ", borderImageSource=" + this.borderImageSource + ")";
    }

    public IconModel(String type, String str, String str2, ImageSourceModel imageSource, ImageSourceModel imageSourceModel) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        this.type = type;
        this.alt = str;
        this.tooltip = str2;
        this.imageSource = imageSource;
        this.borderImageSource = imageSourceModel;
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

    public final ImageSourceModel getImageSource() {
        return this.imageSource;
    }

    public final ImageSourceModel getBorderImageSource() {
        return this.borderImageSource;
    }
}
