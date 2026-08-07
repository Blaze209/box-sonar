package com.box.android.browse.utilities;

import android.os.Bundle;
import com.box.android.base.cpl.ICollectionsHelper;
import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.ScopesStore;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/browse/utilities/CollectionsHelper;", "Lcom/box/android/base/cpl/ICollectionsHelper;", "<init>", "()V", "onItemClickOnCPL", "", "arguments", "Landroid/os/Bundle;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsHelper implements ICollectionsHelper {
    public static final int $stable = 0;

    @Inject
    public CollectionsHelper() {
    }

    @Override // com.box.android.base.cpl.ICollectionsHelper
    public void onItemClickOnCPL(Bundle arguments, ItemModel itemModel) {
        String string;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (arguments == null || (string = arguments.getString(BoxCommonConstants.STORE_KEY)) == null) {
            return;
        }
        Object obj = ScopesStore.INSTANCE.get(string);
        Store store = obj instanceof Store ? (Store) obj : null;
        if (store != null) {
            store.send(new CollectionReducer.Action.OpenItem(itemModel));
        }
    }
}
