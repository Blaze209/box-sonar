package com.box.android.domain.usecases.thumbnail;

import android.graphics.Bitmap;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ThumbnailPreviewUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;", "", "prefetchThumbnail", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getThumbnail", "Lkotlinx/coroutines/flow/Flow;", "Landroid/graphics/Bitmap;", "cancelThumbnailUpdate", "itemId", "Lcom/box/android/domain/models/ItemId;", "cancelPrefetch", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ThumbnailPreviewUseCase {
    void cancelPrefetch(FileModel fileModel);

    void cancelThumbnailUpdate(ItemId itemId);

    Flow<Bitmap> getThumbnail(FileModel fileModel);

    void prefetchThumbnail(FileModel fileModel);
}
