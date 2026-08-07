package com.box.android.data.api.models.collections;

import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionItemType;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/api/models/collections/CollectionItemDTO;", "", "item", "Lcom/box/android/data/api/models/items/IItemDTO;", "containedItemType", "Lcom/box/android/domain/models/CollectionItemType;", "id", "", "<init>", "(Lcom/box/android/data/api/models/items/IItemDTO;Lcom/box/android/domain/models/CollectionItemType;Ljava/lang/String;)V", "getItem", "()Lcom/box/android/data/api/models/items/IItemDTO;", "getContainedItemType", "()Lcom/box/android/domain/models/CollectionItemType;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionItemDTO {
    private final CollectionItemType containedItemType;
    private final String id;
    private final IItemDTO item;

    public static /* synthetic */ CollectionItemDTO copy$default(CollectionItemDTO collectionItemDTO, IItemDTO iItemDTO, CollectionItemType collectionItemType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            iItemDTO = collectionItemDTO.item;
        }
        if ((i & 2) != 0) {
            collectionItemType = collectionItemDTO.containedItemType;
        }
        if ((i & 4) != 0) {
            str = collectionItemDTO.id;
        }
        return collectionItemDTO.copy(iItemDTO, collectionItemType, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IItemDTO getItem() {
        return this.item;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CollectionItemType getContainedItemType() {
        return this.containedItemType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final CollectionItemDTO copy(@Json(name = "contained_item") IItemDTO item, @Json(name = "contained_item_type") CollectionItemType containedItemType, @Json(name = "id") String id) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(containedItemType, "containedItemType");
        Intrinsics.checkNotNullParameter(id, "id");
        return new CollectionItemDTO(item, containedItemType, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionItemDTO)) {
            return false;
        }
        CollectionItemDTO collectionItemDTO = (CollectionItemDTO) other;
        return Intrinsics.areEqual(this.item, collectionItemDTO.item) && this.containedItemType == collectionItemDTO.containedItemType && Intrinsics.areEqual(this.id, collectionItemDTO.id);
    }

    public int hashCode() {
        return (((this.item.hashCode() * 31) + this.containedItemType.hashCode()) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "CollectionItemDTO(item=" + this.item + ", containedItemType=" + this.containedItemType + ", id=" + this.id + ")";
    }

    public CollectionItemDTO(@Json(name = "contained_item") IItemDTO item, @Json(name = "contained_item_type") CollectionItemType containedItemType, @Json(name = "id") String id) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(containedItemType, "containedItemType");
        Intrinsics.checkNotNullParameter(id, "id");
        this.item = item;
        this.containedItemType = containedItemType;
        this.id = id;
    }

    public final IItemDTO getItem() {
        return this.item;
    }

    public final CollectionItemType getContainedItemType() {
        return this.containedItemType;
    }

    public final String getId() {
        return this.id;
    }
}
