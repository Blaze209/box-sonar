package com.box.android.data.service.impl.preview;

import com.box.android.coreservices.models.PreviewFile;
import com.box.android.coreservices.models.PreviewFileAttributes;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: PreviewDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/service/impl/preview/PreviewDataSource;", "", "getPreviewFile", "Lcom/box/android/coreservices/models/PreviewFile;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewFileAttributes", "Lcom/box/android/coreservices/models/PreviewFileAttributes;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/coreservices/models/PreviewFileAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllPreviewFiles", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PreviewDataSource {
    void deleteAllPreviewFiles(FileModel fileModel);

    Object getPreviewFile(FileModel fileModel, PreviewFileAttributes previewFileAttributes, Continuation<? super PreviewFile> continuation);
}
