package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.components.fileactions.DownloadEnvironment;
import com.box.android.base.presentation.components.fileactions.OfflineFilesEnvironment;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.coreservices.utilities.FileActionsManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListEnvironment;", "", "itemListViewEnvironment", "Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "getItemListViewEnvironment", "()Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "browseAnalytics", "Lcom/box/android/browse/utilities/BrowseAnalytics;", "getBrowseAnalytics", "()Lcom/box/android/browse/utilities/BrowseAnalytics;", "boxAccountManagerHelper", "Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "getBoxAccountManagerHelper", "()Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "offlineFilesEnvironment", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "getOfflineFilesEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "downloadEnvironment", "Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "getDownloadEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "boxAiEnvironment", "Lcom/box/android/boxai/BoxAiEnvironment;", "getBoxAiEnvironment", "()Lcom/box/android/boxai/BoxAiEnvironment;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ActionableItemsListEnvironment {
    BoxAccountManagerHelper getBoxAccountManagerHelper();

    BoxAiEnvironment getBoxAiEnvironment();

    BrowseAnalytics getBrowseAnalytics();

    DownloadEnvironment getDownloadEnvironment();

    FileActionsManager getFileActionsManager();

    IItemsListViewEnvironment getItemListViewEnvironment();

    OfflineFilesEnvironment getOfflineFilesEnvironment();
}
