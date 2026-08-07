package com.box.android.preview.iteminformation;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.domain.services.IFileMetadataService;
import com.box.android.domain.services.IItemCollaborationsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.preview.fileactions.UpdateItemInfoEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationEnvironment;", "", "itemCollaborationsService", "Lcom/box/android/domain/services/IItemCollaborationsService;", "updateItemInfoEnvironment", "Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "itemThumbnailEnvironment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "fileMetadataService", "Lcom/box/android/domain/services/IFileMetadataService;", "analytics", "Lcom/box/android/preview/iteminformation/ItemInformationAnalytics;", "<init>", "(Lcom/box/android/domain/services/IItemCollaborationsService;Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;Lcom/box/android/base/cpl/ItemThumbnailEnvironment;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/services/IFileMetadataService;Lcom/box/android/preview/iteminformation/ItemInformationAnalytics;)V", "getItemCollaborationsService", "()Lcom/box/android/domain/services/IItemCollaborationsService;", "getUpdateItemInfoEnvironment", "()Lcom/box/android/preview/fileactions/UpdateItemInfoEnvironment;", "getItemThumbnailEnvironment", "()Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "getItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getFileMetadataService", "()Lcom/box/android/domain/services/IFileMetadataService;", "getAnalytics", "()Lcom/box/android/preview/iteminformation/ItemInformationAnalytics;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationEnvironment {
    public static final int $stable = 8;
    private final ItemInformationAnalytics analytics;
    private final IFileMetadataService fileMetadataService;
    private final IItemCollaborationsService itemCollaborationsService;
    private final IRemoteItemService itemService;
    private final ItemThumbnailEnvironment itemThumbnailEnvironment;
    private final UpdateItemInfoEnvironment updateItemInfoEnvironment;

    @Inject
    public ItemInformationEnvironment(IItemCollaborationsService itemCollaborationsService, UpdateItemInfoEnvironment updateItemInfoEnvironment, ItemThumbnailEnvironment itemThumbnailEnvironment, IRemoteItemService itemService, IFileMetadataService fileMetadataService, ItemInformationAnalytics analytics) {
        Intrinsics.checkNotNullParameter(itemCollaborationsService, "itemCollaborationsService");
        Intrinsics.checkNotNullParameter(updateItemInfoEnvironment, "updateItemInfoEnvironment");
        Intrinsics.checkNotNullParameter(itemThumbnailEnvironment, "itemThumbnailEnvironment");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(fileMetadataService, "fileMetadataService");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.itemCollaborationsService = itemCollaborationsService;
        this.updateItemInfoEnvironment = updateItemInfoEnvironment;
        this.itemThumbnailEnvironment = itemThumbnailEnvironment;
        this.itemService = itemService;
        this.fileMetadataService = fileMetadataService;
        this.analytics = analytics;
    }

    public final IItemCollaborationsService getItemCollaborationsService() {
        return this.itemCollaborationsService;
    }

    public final UpdateItemInfoEnvironment getUpdateItemInfoEnvironment() {
        return this.updateItemInfoEnvironment;
    }

    public final ItemThumbnailEnvironment getItemThumbnailEnvironment() {
        return this.itemThumbnailEnvironment;
    }

    public final IRemoteItemService getItemService() {
        return this.itemService;
    }

    public final IFileMetadataService getFileMetadataService() {
        return this.fileMetadataService;
    }

    public final ItemInformationAnalytics getAnalytics() {
        return this.analytics;
    }
}
