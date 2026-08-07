package com.box.android.preview.utils;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IPreviewService;
import com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewPrefetcher.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/utils/PreviewPrefetcher;", "", "previewService", "Lcom/box/android/domain/services/IPreviewService;", "thumbnailPreviewInteractor", "Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;", "<init>", "(Lcom/box/android/domain/services/IPreviewService;Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;)V", "prefetch", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "observabilityId", "", "cancel", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewPrefetcher {
    public static final int $stable = 8;
    private final IPreviewService previewService;
    private final ThumbnailPreviewUseCase thumbnailPreviewInteractor;

    @Inject
    public PreviewPrefetcher(IPreviewService previewService, ThumbnailPreviewUseCase thumbnailPreviewInteractor) {
        Intrinsics.checkNotNullParameter(previewService, "previewService");
        Intrinsics.checkNotNullParameter(thumbnailPreviewInteractor, "thumbnailPreviewInteractor");
        this.previewService = previewService;
        this.thumbnailPreviewInteractor = thumbnailPreviewInteractor;
    }

    public final void prefetch(FileModel fileModel, String observabilityId) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(observabilityId, "observabilityId");
        this.previewService.prefetchPreviewData(fileModel, observabilityId);
        this.thumbnailPreviewInteractor.prefetchThumbnail(fileModel);
    }

    public final void cancel(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.previewService.cancelPrefetch(fileModel);
        this.thumbnailPreviewInteractor.cancelPrefetch(fileModel);
    }
}
