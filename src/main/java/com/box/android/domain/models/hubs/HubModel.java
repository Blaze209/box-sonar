package com.box.android.domain.models.hubs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\\\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006*"}, d2 = {"Lcom/box/android/domain/models/hubs/HubModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "bannerImage", "Lcom/box/android/domain/models/hubs/HubAssetModel;", "iconImage", "updatedAt", "Ljava/util/Date;", "accessCount", "", "title", "descriptionPreview", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/hubs/HubAssetModel;Lcom/box/android/domain/models/hubs/HubAssetModel;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getBannerImage", "()Lcom/box/android/domain/models/hubs/HubAssetModel;", "getIconImage", "getUpdatedAt", "()Ljava/util/Date;", "getAccessCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getDescriptionPreview", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/hubs/HubAssetModel;Lcom/box/android/domain/models/hubs/HubAssetModel;Ljava/util/Date;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/domain/models/hubs/HubModel;", "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HubModel implements DomainModel {
    private final Integer accessCount;
    private final HubAssetModel bannerImage;
    private final String descriptionPreview;
    private final HubAssetModel iconImage;
    private final String id;
    private final String title;
    private final Date updatedAt;

    public static /* synthetic */ HubModel copy$default(HubModel hubModel, String str, HubAssetModel hubAssetModel, HubAssetModel hubAssetModel2, Date date, Integer num, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubModel.id;
        }
        if ((i & 2) != 0) {
            hubAssetModel = hubModel.bannerImage;
        }
        if ((i & 4) != 0) {
            hubAssetModel2 = hubModel.iconImage;
        }
        if ((i & 8) != 0) {
            date = hubModel.updatedAt;
        }
        if ((i & 16) != 0) {
            num = hubModel.accessCount;
        }
        if ((i & 32) != 0) {
            str2 = hubModel.title;
        }
        if ((i & 64) != 0) {
            str3 = hubModel.descriptionPreview;
        }
        String str4 = str2;
        String str5 = str3;
        Integer num2 = num;
        HubAssetModel hubAssetModel3 = hubAssetModel2;
        return hubModel.copy(str, hubAssetModel, hubAssetModel3, date, num2, str4, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HubAssetModel getBannerImage() {
        return this.bannerImage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HubAssetModel getIconImage() {
        return this.iconImage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getAccessCount() {
        return this.accessCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDescriptionPreview() {
        return this.descriptionPreview;
    }

    public final HubModel copy(String id, HubAssetModel bannerImage, HubAssetModel iconImage, Date updatedAt, Integer accessCount, String title, String descriptionPreview) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
        Intrinsics.checkNotNullParameter(iconImage, "iconImage");
        return new HubModel(id, bannerImage, iconImage, updatedAt, accessCount, title, descriptionPreview);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubModel)) {
            return false;
        }
        HubModel hubModel = (HubModel) other;
        return Intrinsics.areEqual(this.id, hubModel.id) && Intrinsics.areEqual(this.bannerImage, hubModel.bannerImage) && Intrinsics.areEqual(this.iconImage, hubModel.iconImage) && Intrinsics.areEqual(this.updatedAt, hubModel.updatedAt) && Intrinsics.areEqual(this.accessCount, hubModel.accessCount) && Intrinsics.areEqual(this.title, hubModel.title) && Intrinsics.areEqual(this.descriptionPreview, hubModel.descriptionPreview);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.bannerImage.hashCode()) * 31) + this.iconImage.hashCode()) * 31;
        Date date = this.updatedAt;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Integer num = this.accessCount;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.title;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.descriptionPreview;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HubModel(id=" + this.id + ", bannerImage=" + this.bannerImage + ", iconImage=" + this.iconImage + ", updatedAt=" + this.updatedAt + ", accessCount=" + this.accessCount + ", title=" + this.title + ", descriptionPreview=" + this.descriptionPreview + ")";
    }

    public HubModel(String id, HubAssetModel bannerImage, HubAssetModel iconImage, Date date, Integer num, String str, String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
        Intrinsics.checkNotNullParameter(iconImage, "iconImage");
        this.id = id;
        this.bannerImage = bannerImage;
        this.iconImage = iconImage;
        this.updatedAt = date;
        this.accessCount = num;
        this.title = str;
        this.descriptionPreview = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final HubAssetModel getBannerImage() {
        return this.bannerImage;
    }

    public final HubAssetModel getIconImage() {
        return this.iconImage;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Integer getAccessCount() {
        return this.accessCount;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescriptionPreview() {
        return this.descriptionPreview;
    }
}
