package com.box.android.base.presentation.multiselect;

import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SelectionId.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\b\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"HUB_TYPE", "", "toSelectionId", "Lcom/box/android/base/presentation/multiselect/SelectionId;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/hubs/HubModel;", "hubSelectionId", HubDetailsInitialContext.HUB_ID_KEY, "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/domain/models/DomainModel;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SelectionIdKt {
    public static final String HUB_TYPE = "hub";

    public static final SelectionId toSelectionId(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        return new SelectionId(itemModel.boxIdOrThrow(), itemModel.getItemId().getType().getValue());
    }

    public static final SelectionId toSelectionId(HubModel hubModel) {
        Intrinsics.checkNotNullParameter(hubModel, "<this>");
        return new SelectionId(hubModel.getId(), HUB_TYPE);
    }

    public static final SelectionId hubSelectionId(String hubId) {
        Intrinsics.checkNotNullParameter(hubId, "hubId");
        return new SelectionId(hubId, HUB_TYPE);
    }

    public static final SelectionId toSelectionId(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<this>");
        return new SelectionId(remote.getBoxId(), remote.getType().getValue());
    }

    public static final SelectionId toSelectionId(DomainModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "<this>");
        if (domainModel instanceof ItemModel) {
            return toSelectionId((ItemModel) domainModel);
        }
        if (domainModel instanceof HubModel) {
            return toSelectionId((HubModel) domainModel);
        }
        if (domainModel instanceof SelectionItemInfo) {
            SelectionItemInfo selectionItemInfo = (SelectionItemInfo) domainModel;
            return new SelectionId(selectionItemInfo.getId(), selectionItemInfo.getType());
        }
        throw new IllegalArgumentException("Unsupported DomainModel type: " + Reflection.getOrCreateKotlinClass(domainModel.getClass()));
    }
}
