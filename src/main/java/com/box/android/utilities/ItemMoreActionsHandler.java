package com.box.android.utilities;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemMoreActionsHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016JH\u0010\u0010\u001a\u00020\u000b2>\u0010\u000e\u001a:\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011j\u0004\u0018\u0001`\u0018H\u0016J.\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH\u0016J.\u0010\u0019\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/utilities/ItemMoreActionsHandler;", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "itemActionHandlerFactory", "Lcom/box/android/utilities/ItemActionHandler$Factory;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Lcom/box/android/utilities/ItemActionHandler$Factory;Landroidx/appcompat/app/AppCompatActivity;)V", "itemActionHandler", "Lcom/box/android/utilities/ItemActionHandler;", "registerMoreActionsHandler", "", "unregisterMoreActionsHandler", "setOnMenuClosedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "setOnBottomSheetActionListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "menuItemId", "Lcom/box/android/domain/models/item/ItemModel;", "itemModel", "Lcom/box/android/base/presentation/utilities/BottomSheetActionListener;", "showBottomSheet", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "availableActions", "", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "handleMoreActionsResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemMoreActionsHandler implements IItemMoreActionsHandler {
    public static final int $stable = 8;
    private final ItemActionHandler itemActionHandler;

    /* JADX INFO: compiled from: ItemMoreActionsHandler.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/utilities/ItemMoreActionsHandler$Factory;", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/utilities/ItemMoreActionsHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory extends IItemMoreActionsHandler.Factory {
        @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler.Factory
        ItemMoreActionsHandler create(AppCompatActivity activity);
    }

    @AssistedInject
    public ItemMoreActionsHandler(ItemActionHandler.Factory itemActionHandlerFactory, @Assisted AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(itemActionHandlerFactory, "itemActionHandlerFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.itemActionHandler = itemActionHandlerFactory.create(activity);
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public void registerMoreActionsHandler() {
        this.itemActionHandler.registerItemActionHandler();
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public void unregisterMoreActionsHandler() {
        this.itemActionHandler.unregisterItemActionHandler();
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public void setOnMenuClosedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemActionHandler.setOnItemClosedListener(listener);
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public void setOnBottomSheetActionListener(Function2<? super Integer, ? super ItemModel, Unit> listener) {
        this.itemActionHandler.setOnBottomSheetActionListener(listener);
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public void showBottomSheet(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<Integer> availableActions) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        Intrinsics.checkNotNullParameter(availableActions, "availableActions");
        IItemActionHandler.showBottomSheet$default(this.itemActionHandler, itemModel, bottomSheetMenuType, launchContext, (DialogInterface.OnShowListener) null, availableActions, 8, (Object) null);
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public void showBottomSheet(BoxItem item, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<Integer> availableActions) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        Intrinsics.checkNotNullParameter(availableActions, "availableActions");
        IItemActionHandler.showBottomSheet$default(this.itemActionHandler, item, bottomSheetMenuType, launchContext, (DialogInterface.OnShowListener) null, availableActions, 8, (Object) null);
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler
    public boolean handleMoreActionsResult(int requestCode, int resultCode, Intent data) {
        return this.itemActionHandler.handleActivityResult(requestCode, resultCode, data);
    }
}
