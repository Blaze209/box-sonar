package com.box.android.base.presentation.utilities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IItemMoreActionsHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001 J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&JH\u0010\b\u001a\u00020\u00032>\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\u0010H&J2\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H&J2\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H&J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "", "registerMoreActionsHandler", "", "unregisterMoreActionsHandler", "setOnMenuClosedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "setOnBottomSheetActionListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "menuItemId", "Lcom/box/android/domain/models/item/ItemModel;", "itemModel", "Lcom/box/android/base/presentation/utilities/BottomSheetActionListener;", "showBottomSheet", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "availableActions", "", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "handleMoreActionsResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Factory", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IItemMoreActionsHandler {

    /* JADX INFO: compiled from: IItemMoreActionsHandler.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        IItemMoreActionsHandler create(AppCompatActivity activity);
    }

    boolean handleMoreActionsResult(int requestCode, int resultCode, Intent data);

    void registerMoreActionsHandler();

    void setOnBottomSheetActionListener(Function2<? super Integer, ? super ItemModel, Unit> listener);

    void setOnMenuClosedListener(Function0<Unit> listener);

    void showBottomSheet(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<Integer> availableActions);

    void showBottomSheet(BoxItem item, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<Integer> availableActions);

    void unregisterMoreActionsHandler();

    /* JADX INFO: compiled from: IItemMoreActionsHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showBottomSheet$default(IItemMoreActionsHandler iItemMoreActionsHandler, ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomSheet");
        }
        if ((i & 4) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        iItemMoreActionsHandler.showBottomSheet(itemModel, bottomSheetMenuType, launchContext, (List<Integer>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showBottomSheet$default(IItemMoreActionsHandler iItemMoreActionsHandler, BoxItem boxItem, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomSheet");
        }
        if ((i & 4) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        iItemMoreActionsHandler.showBottomSheet(boxItem, bottomSheetMenuType, launchContext, (List<Integer>) list);
    }
}
