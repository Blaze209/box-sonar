package com.box.android.base.routing.utilities;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: IPresentationRouter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/routing/utilities/IPresentationRouter;", "", "navigateToCollectionMultiSelectDialog", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "currentActivity", "Landroidx/appcompat/app/AppCompatActivity;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPresentationRouter {
    void navigateToCollectionMultiSelectDialog(ItemModel itemModel, AppCompatActivity currentActivity);
}
