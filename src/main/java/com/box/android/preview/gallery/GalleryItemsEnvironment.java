package com.box.android.preview.gallery;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.domain.services.IGalleryItemsService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalleryItemsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/gallery/GalleryItemsEnvironment;", "", "galleryItemsService", "Lcom/box/android/domain/services/IGalleryItemsService;", "itemThumbnailEnvironment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "<init>", "(Lcom/box/android/domain/services/IGalleryItemsService;Lcom/box/android/base/cpl/ItemThumbnailEnvironment;)V", "getGalleryItemsService", "()Lcom/box/android/domain/services/IGalleryItemsService;", "getItemThumbnailEnvironment", "()Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GalleryItemsEnvironment {
    public static final int $stable = 8;
    private final IGalleryItemsService galleryItemsService;
    private final ItemThumbnailEnvironment itemThumbnailEnvironment;

    @Inject
    public GalleryItemsEnvironment(IGalleryItemsService galleryItemsService, ItemThumbnailEnvironment itemThumbnailEnvironment) {
        Intrinsics.checkNotNullParameter(galleryItemsService, "galleryItemsService");
        Intrinsics.checkNotNullParameter(itemThumbnailEnvironment, "itemThumbnailEnvironment");
        this.galleryItemsService = galleryItemsService;
        this.itemThumbnailEnvironment = itemThumbnailEnvironment;
    }

    public final IGalleryItemsService getGalleryItemsService() {
        return this.galleryItemsService;
    }

    public final ItemThumbnailEnvironment getItemThumbnailEnvironment() {
        return this.itemThumbnailEnvironment;
    }
}
