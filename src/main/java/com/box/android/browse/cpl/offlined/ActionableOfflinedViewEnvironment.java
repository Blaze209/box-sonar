package com.box.android.browse.cpl.offlined;

import com.box.android.base.presentation.components.fileactions.DownloadEnvironment;
import com.box.android.base.presentation.components.fileactions.OfflineFilesEnvironment;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.coreservices.utilities.FileActionsManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflinedReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/box/android/browse/cpl/offlined/ActionableOfflinedViewEnvironment;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListEnvironment;", "itemListViewEnvironment", "Lcom/box/android/browse/cpl/offlined/OfflinedViewEnvironment;", "browseAnalytics", "Lcom/box/android/browse/utilities/BrowseAnalytics;", "boxAccountManagerHelper", "Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "offlineFilesEnvironment", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "downloadEnvironment", "Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "boxAiEnvironment", "Lcom/box/android/boxai/BoxAiEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/offlined/OfflinedViewEnvironment;Lcom/box/android/browse/utilities/BrowseAnalytics;Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;Lcom/box/android/boxai/BoxAiEnvironment;)V", "getItemListViewEnvironment", "()Lcom/box/android/browse/cpl/offlined/OfflinedViewEnvironment;", "getBrowseAnalytics", "()Lcom/box/android/browse/utilities/BrowseAnalytics;", "getBoxAccountManagerHelper", "()Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getOfflineFilesEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/OfflineFilesEnvironment;", "getDownloadEnvironment", "()Lcom/box/android/base/presentation/components/fileactions/DownloadEnvironment;", "getBoxAiEnvironment", "()Lcom/box/android/boxai/BoxAiEnvironment;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionableOfflinedViewEnvironment implements ActionableItemsListEnvironment {
    public static final int $stable = 8;
    private final BoxAccountManagerHelper boxAccountManagerHelper;
    private final BoxAiEnvironment boxAiEnvironment;
    private final BrowseAnalytics browseAnalytics;
    private final DownloadEnvironment downloadEnvironment;
    private final FileActionsManager fileActionsManager;
    private final OfflinedViewEnvironment itemListViewEnvironment;
    private final OfflineFilesEnvironment offlineFilesEnvironment;

    @Inject
    public ActionableOfflinedViewEnvironment(OfflinedViewEnvironment itemListViewEnvironment, BrowseAnalytics browseAnalytics, BoxAccountManagerHelper boxAccountManagerHelper, FileActionsManager fileActionsManager, OfflineFilesEnvironment offlineFilesEnvironment, DownloadEnvironment downloadEnvironment, BoxAiEnvironment boxAiEnvironment) {
        Intrinsics.checkNotNullParameter(itemListViewEnvironment, "itemListViewEnvironment");
        Intrinsics.checkNotNullParameter(browseAnalytics, "browseAnalytics");
        Intrinsics.checkNotNullParameter(boxAccountManagerHelper, "boxAccountManagerHelper");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(offlineFilesEnvironment, "offlineFilesEnvironment");
        Intrinsics.checkNotNullParameter(downloadEnvironment, "downloadEnvironment");
        Intrinsics.checkNotNullParameter(boxAiEnvironment, "boxAiEnvironment");
        this.itemListViewEnvironment = itemListViewEnvironment;
        this.browseAnalytics = browseAnalytics;
        this.boxAccountManagerHelper = boxAccountManagerHelper;
        this.fileActionsManager = fileActionsManager;
        this.offlineFilesEnvironment = offlineFilesEnvironment;
        this.downloadEnvironment = downloadEnvironment;
        this.boxAiEnvironment = boxAiEnvironment;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public OfflinedViewEnvironment getItemListViewEnvironment() {
        return this.itemListViewEnvironment;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public BrowseAnalytics getBrowseAnalytics() {
        return this.browseAnalytics;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public BoxAccountManagerHelper getBoxAccountManagerHelper() {
        return this.boxAccountManagerHelper;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public OfflineFilesEnvironment getOfflineFilesEnvironment() {
        return this.offlineFilesEnvironment;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public DownloadEnvironment getDownloadEnvironment() {
        return this.downloadEnvironment;
    }

    @Override // com.box.android.browse.cpl.itemsList.ActionableItemsListEnvironment
    public BoxAiEnvironment getBoxAiEnvironment() {
        return this.boxAiEnvironment;
    }
}
