package com.box.android.data.persistence.localItems;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalIdToServerIdRelationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/persistence/localItems/LocalIdToServerIdRelationEntity;", "", "localId", "Lcom/box/android/domain/models/ItemId$Local;", "type", "Lcom/box/android/domain/models/item/ItemType;", "serverId", "", "<init>", "(Lcom/box/android/domain/models/ItemId$Local;Lcom/box/android/domain/models/item/ItemType;Ljava/lang/String;)V", "getLocalId", "()Lcom/box/android/domain/models/ItemId$Local;", "getType", "()Lcom/box/android/domain/models/item/ItemType;", "getServerId", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalIdToServerIdRelationEntity {
    private final ItemId.Local localId;
    private final String serverId;
    private final ItemType type;

    public LocalIdToServerIdRelationEntity(ItemId.Local localId, ItemType type, String serverId) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        this.localId = localId;
        this.type = type;
        this.serverId = serverId;
    }

    public final ItemId.Local getLocalId() {
        return this.localId;
    }

    public final ItemType getType() {
        return this.type;
    }

    public final String getServerId() {
        return this.serverId;
    }
}
