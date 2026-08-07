package com.box.android.base.cpl;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.services.IHubsService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemThumbnailReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "hubsService", "Lcom/box/android/domain/services/IHubsService;", "<init>", "(Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/services/IHubsService;)V", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "getHubsService", "()Lcom/box/android/domain/services/IHubsService;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemThumbnailEnvironment {
    public static final int $stable = 8;
    private final IHubsService hubsService;
    private final ThumbnailManager thumbnailManager;

    @Inject
    public ItemThumbnailEnvironment(ThumbnailManager thumbnailManager, IHubsService hubsService) {
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        Intrinsics.checkNotNullParameter(hubsService, "hubsService");
        this.thumbnailManager = thumbnailManager;
        this.hubsService = hubsService;
    }

    public final IHubsService getHubsService() {
        return this.hubsService;
    }

    public final ThumbnailManager getThumbnailManager() {
        return this.thumbnailManager;
    }
}
