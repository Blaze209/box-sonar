package com.box.android.base.presentation.utilities;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.models.BoxItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IItemActionHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001+J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&JH\u0010\t\u001a\u00020\u00032>\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0004\u0018\u0001`\u0011H&J&\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J2\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\"\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J>\u0010!\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)H&J>\u0010!\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)H&¨\u0006,À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "", "registerItemActionHandler", "", "unregisterItemActionHandler", "setOnItemClosedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "Lcom/box/android/base/presentation/utilities/ItemClosedListener;", "setOnBottomSheetActionListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "menuItemId", "Lcom/box/android/domain/models/item/ItemModel;", "itemModel", "Lcom/box/android/base/presentation/utilities/BottomSheetActionListener;", "onItemClick", "shouldLog", "", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "onItemPicked", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "sharedLinkUrl", "", "handleActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showBottomSheet", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "onShowListener", "Landroid/content/DialogInterface$OnShowListener;", "availableActions", "", "item", "Factory", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IItemActionHandler {

    /* JADX INFO: compiled from: IItemActionHandler.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        IItemActionHandler create(AppCompatActivity activity);
    }

    boolean handleActivityResult(int requestCode, int resultCode, Intent data);

    void onItemClick(ItemModel itemModel, boolean shouldLog, PreviewSource previewSource);

    void onItemClick(BoxItem boxItem, boolean shouldLog, String sharedLinkUrl, PreviewSource previewSource);

    void onItemPicked(ItemModel itemModel);

    void onItemPicked(BoxItem boxItem);

    void registerItemActionHandler();

    void setOnBottomSheetActionListener(Function2<? super Integer, ? super ItemModel, Unit> listener);

    void setOnItemClosedListener(Function0<Unit> listener);

    void showBottomSheet(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, List<Integer> availableActions);

    void showBottomSheet(BoxItem item, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, List<Integer> availableActions);

    void unregisterItemActionHandler();

    /* JADX INFO: compiled from: IItemActionHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void onItemClick$default(IItemActionHandler iItemActionHandler, ItemModel itemModel, boolean z, PreviewSource previewSource, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemClick");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            previewSource = null;
        }
        iItemActionHandler.onItemClick(itemModel, z, previewSource);
    }

    static /* synthetic */ void onItemClick$default(IItemActionHandler iItemActionHandler, BoxItem boxItem, boolean z, String str, PreviewSource previewSource, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemClick");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            previewSource = null;
        }
        iItemActionHandler.onItemClick(boxItem, z, str, previewSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showBottomSheet$default(IItemActionHandler iItemActionHandler, ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomSheet");
        }
        if ((i & 4) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        BottomSheetAttributes.LaunchContext launchContext2 = launchContext;
        if ((i & 8) != 0) {
            onShowListener = null;
        }
        DialogInterface.OnShowListener onShowListener2 = onShowListener;
        if ((i & 16) != 0) {
            list = CollectionsKt.emptyList();
        }
        iItemActionHandler.showBottomSheet(itemModel, bottomSheetMenuType, launchContext2, onShowListener2, (List<Integer>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showBottomSheet$default(IItemActionHandler iItemActionHandler, BoxItem boxItem, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomSheet");
        }
        if ((i & 4) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        BottomSheetAttributes.LaunchContext launchContext2 = launchContext;
        if ((i & 8) != 0) {
            onShowListener = null;
        }
        DialogInterface.OnShowListener onShowListener2 = onShowListener;
        if ((i & 16) != 0) {
            list = CollectionsKt.emptyList();
        }
        iItemActionHandler.showBottomSheet(boxItem, bottomSheetMenuType, launchContext2, onShowListener2, (List<Integer>) list);
    }
}
