package com.box.android.data.api.models.items.mini;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemType;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IItemIdDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "Lcom/box/android/data/api/models/items/mini/IItemIdDTO;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/item/ItemType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemIdDTO implements IItemIdDTO {
    private final String id;
    private final ItemType type;

    public static /* synthetic */ ItemIdDTO copy$default(ItemIdDTO itemIdDTO, String str, ItemType itemType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemIdDTO.id;
        }
        if ((i & 2) != 0) {
            itemType = itemIdDTO.type;
        }
        return itemIdDTO.copy(str, itemType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    public final ItemIdDTO copy(@Json(name = "id") String id, @Json(name = "type") ItemType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ItemIdDTO(id, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemIdDTO)) {
            return false;
        }
        ItemIdDTO itemIdDTO = (ItemIdDTO) other;
        return Intrinsics.areEqual(this.id, itemIdDTO.id) && this.type == itemIdDTO.type;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ItemIdDTO(id=" + this.id + ", type=" + this.type + ")";
    }

    public ItemIdDTO(@Json(name = "id") String id, @Json(name = "type") ItemType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemIdDTO
    public String getId() {
        return this.id;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemIdDTO
    public ItemType getType() {
        return this.type;
    }
}
