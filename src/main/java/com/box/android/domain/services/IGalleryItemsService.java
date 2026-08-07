package com.box.android.domain.services;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IGalleryItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IGalleryItemsService;", "", "fetchPreviewItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "fileModel", "(Lcom/box/android/domain/models/preview/PreviewSource;Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isGalleryAvailable", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IGalleryItemsService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object fetchPreviewItems(PreviewSource previewSource, FileModel fileModel, Continuation<? super Flow<? extends List<FileModel>>> continuation);

    boolean isGalleryAvailable(PreviewSource previewSource, FileModel fileModel);

    /* JADX INFO: compiled from: IGalleryItemsService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/services/IGalleryItemsService$Companion;", "", "<init>", "()V", "PREVIEW_SOURCES_GALLERY_ALLOWED_FOR_NON_ROOTED_FILES", "", "Lcom/box/android/domain/models/preview/PreviewSource;", "getPREVIEW_SOURCES_GALLERY_ALLOWED_FOR_NON_ROOTED_FILES", "()Ljava/util/List;", "PREVIEW_SOURCES_GALLERY_NOT_ALLOWED", "getPREVIEW_SOURCES_GALLERY_NOT_ALLOWED", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final List<PreviewSource> PREVIEW_SOURCES_GALLERY_ALLOWED_FOR_NON_ROOTED_FILES = CollectionsKt.listOf((Object[]) new PreviewSource[]{PreviewSource.Offline.INSTANCE, PreviewSource.Recents.INSTANCE, PreviewSource.CaptureHistory.INSTANCE});
        private static final List<PreviewSource> PREVIEW_SOURCES_GALLERY_NOT_ALLOWED = CollectionsKt.listOf((Object[]) new PreviewSource[]{PreviewSource.Collection.INSTANCE, PreviewSource.Favorites.INSTANCE, PreviewSource.Transfers.INSTANCE});

        private Companion() {
        }

        public final List<PreviewSource> getPREVIEW_SOURCES_GALLERY_ALLOWED_FOR_NON_ROOTED_FILES() {
            return PREVIEW_SOURCES_GALLERY_ALLOWED_FOR_NON_ROOTED_FILES;
        }

        public final List<PreviewSource> getPREVIEW_SOURCES_GALLERY_NOT_ALLOWED() {
            return PREVIEW_SOURCES_GALLERY_NOT_ALLOWED;
        }
    }
}
