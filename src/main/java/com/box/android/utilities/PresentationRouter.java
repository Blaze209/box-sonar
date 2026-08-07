package com.box.android.utilities;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.routing.utilities.IPresentationRouter;
import com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment;
import com.box.android.domain.models.item.ItemModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentationRouter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/utilities/PresentationRouter;", "Lcom/box/android/base/routing/utilities/IPresentationRouter;", "<init>", "()V", "navigateToCollectionMultiSelectDialog", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "currentActivity", "Landroidx/appcompat/app/AppCompatActivity;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PresentationRouter implements IPresentationRouter {
    public static final int $stable = 0;

    @Inject
    public PresentationRouter() {
    }

    @Override // com.box.android.base.routing.utilities.IPresentationRouter
    public void navigateToCollectionMultiSelectDialog(ItemModel itemModel, AppCompatActivity currentActivity) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
        CollectionsMultiSelectDialogFragment.INSTANCE.newInstance(itemModel).show(currentActivity.getSupportFragmentManager(), CollectionsMultiSelectDialogFragment.TAG);
    }
}
