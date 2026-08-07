package com.box.android.data.persistence.localItems;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: LocalItemEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003Ja\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006-"}, d2 = {"Lcom/box/android/data/persistence/localItems/LocalItemEntity;", "", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "contentUrl", "", "name", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId;", "createdAt", "Ljava/util/Date;", "contentModifiedAt", "localFileSha1", "<init>", "(Lcom/box/android/domain/models/ItemId$Local;Lcom/box/android/domain/models/item/ItemType;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId$Local;", "getItemType", "()Lcom/box/android/domain/models/item/ItemType;", "getContentUrl", "()Ljava/lang/String;", "getName", "getParentId", "()Lcom/box/android/domain/models/ItemId;", "getCreatedAt", "()Ljava/util/Date;", "getContentModifiedAt", "getLocalFileSha1", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LocalItemEntity {
    private final Date contentModifiedAt;
    private final String contentUrl;
    private final Date createdAt;
    private final ItemId.Local itemId;
    private final ItemType itemType;
    private final String localFileSha1;
    private final String name;
    private final ItemId parentId;

    public static /* synthetic */ LocalItemEntity copy$default(LocalItemEntity localItemEntity, ItemId.Local local, ItemType itemType, String str, String str2, ItemId itemId, Date date, Date date2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            local = localItemEntity.itemId;
        }
        if ((i & 2) != 0) {
            itemType = localItemEntity.itemType;
        }
        if ((i & 4) != 0) {
            str = localItemEntity.contentUrl;
        }
        if ((i & 8) != 0) {
            str2 = localItemEntity.name;
        }
        if ((i & 16) != 0) {
            itemId = localItemEntity.parentId;
        }
        if ((i & 32) != 0) {
            date = localItemEntity.createdAt;
        }
        if ((i & 64) != 0) {
            date2 = localItemEntity.contentModifiedAt;
        }
        if ((i & 128) != 0) {
            str3 = localItemEntity.localFileSha1;
        }
        Date date3 = date2;
        String str4 = str3;
        ItemId itemId2 = itemId;
        Date date4 = date;
        return localItemEntity.copy(local, itemType, str, str2, itemId2, date4, date3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId.Local getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getItemType() {
        return this.itemType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentUrl() {
        return this.contentUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ItemId getParentId() {
        return this.parentId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLocalFileSha1() {
        return this.localFileSha1;
    }

    public final LocalItemEntity copy(ItemId.Local itemId, ItemType itemType, String contentUrl, String name, ItemId parentId, Date createdAt, Date contentModifiedAt, String localFileSha1) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new LocalItemEntity(itemId, itemType, contentUrl, name, parentId, createdAt, contentModifiedAt, localFileSha1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalItemEntity)) {
            return false;
        }
        LocalItemEntity localItemEntity = (LocalItemEntity) other;
        return Intrinsics.areEqual(this.itemId, localItemEntity.itemId) && this.itemType == localItemEntity.itemType && Intrinsics.areEqual(this.contentUrl, localItemEntity.contentUrl) && Intrinsics.areEqual(this.name, localItemEntity.name) && Intrinsics.areEqual(this.parentId, localItemEntity.parentId) && Intrinsics.areEqual(this.createdAt, localItemEntity.createdAt) && Intrinsics.areEqual(this.contentModifiedAt, localItemEntity.contentModifiedAt) && Intrinsics.areEqual(this.localFileSha1, localItemEntity.localFileSha1);
    }

    public int hashCode() {
        int iHashCode = ((this.itemId.hashCode() * 31) + this.itemType.hashCode()) * 31;
        String str = this.contentUrl;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31;
        ItemId itemId = this.parentId;
        int iHashCode3 = (((iHashCode2 + (itemId == null ? 0 : itemId.hashCode())) * 31) + this.createdAt.hashCode()) * 31;
        Date date = this.contentModifiedAt;
        int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
        String str2 = this.localFileSha1;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LocalItemEntity(itemId=" + this.itemId + ", itemType=" + this.itemType + ", contentUrl=" + this.contentUrl + ", name=" + this.name + ", parentId=" + this.parentId + ", createdAt=" + this.createdAt + ", contentModifiedAt=" + this.contentModifiedAt + ", localFileSha1=" + this.localFileSha1 + ")";
    }

    public LocalItemEntity(ItemId.Local itemId, ItemType itemType, String str, String name, ItemId itemId2, Date createdAt, Date date, String str2) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.itemId = itemId;
        this.itemType = itemType;
        this.contentUrl = str;
        this.name = name;
        this.parentId = itemId2;
        this.createdAt = createdAt;
        this.contentModifiedAt = date;
        this.localFileSha1 = str2;
    }

    public final ItemId.Local getItemId() {
        return this.itemId;
    }

    public final ItemType getItemType() {
        return this.itemType;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final ItemId getParentId() {
        return this.parentId;
    }

    public /* synthetic */ LocalItemEntity(ItemId.Local local, ItemType itemType, String str, String str2, ItemId itemId, Date date, Date date2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(local, itemType, str, str2, itemId, (i & 32) != 0 ? new Date() : date, (i & 64) != 0 ? null : date2, (i & 128) != 0 ? null : str3);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    public final String getLocalFileSha1() {
        return this.localFileSha1;
    }
}
