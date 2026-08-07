package com.box.android.domain.services;

import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IPreviewService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IPreviewService;", "", "getPreviewData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/services/PreviewDataState;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "observabilityId", "", "prefetchPreviewData", "", "deleteCachedPreview", "cancelPrefetch", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPreviewService {
    void cancelPrefetch(FileModel fileModel);

    void deleteCachedPreview(FileModel fileModel);

    Flow<PreviewDataState> getPreviewData(FileModel fileModel, String observabilityId);

    void prefetchPreviewData(FileModel fileModel, String observabilityId);
}
