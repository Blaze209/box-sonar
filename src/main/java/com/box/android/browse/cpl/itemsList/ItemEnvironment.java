package com.box.android.browse.cpl.itemsList;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;", "", "thumbnailEnvironment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "boxModelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "<init>", "(Lcom/box/android/base/cpl/ItemThumbnailEnvironment;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;)V", "getThumbnailEnvironment", "()Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "getBoxModelOfflineManagerWrapper", "()Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemEnvironment {
    public static final int $stable = 8;
    private final BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper;
    private final ItemThumbnailEnvironment thumbnailEnvironment;

    @Inject
    public ItemEnvironment(ItemThumbnailEnvironment thumbnailEnvironment, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        Intrinsics.checkNotNullParameter(thumbnailEnvironment, "thumbnailEnvironment");
        Intrinsics.checkNotNullParameter(boxModelOfflineManagerWrapper, "boxModelOfflineManagerWrapper");
        this.thumbnailEnvironment = thumbnailEnvironment;
        this.boxModelOfflineManagerWrapper = boxModelOfflineManagerWrapper;
    }

    public final ItemThumbnailEnvironment getThumbnailEnvironment() {
        return this.thumbnailEnvironment;
    }

    public final BoxModelOfflineManagerWrapper getBoxModelOfflineManagerWrapper() {
        return this.boxModelOfflineManagerWrapper;
    }
}
