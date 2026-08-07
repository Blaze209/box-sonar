package com.box.android.data.service.impl.preview.helpers;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.FileWithRepresentationsResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: PreviewFileWithRepresentationsWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"getRemoteError", "Lcom/box/android/domain/models/DomainError;", "Lcom/box/android/domain/services/FileWithRepresentationsResult;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewFileWithRepresentationsWrapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DomainError getRemoteError(FileWithRepresentationsResult fileWithRepresentationsResult) {
        if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Success) {
            return null;
        }
        if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Cached) {
            return ((FileWithRepresentationsResult.Cached) fileWithRepresentationsResult).getRemoteFetchError();
        }
        if (fileWithRepresentationsResult instanceof FileWithRepresentationsResult.Error) {
            return ((FileWithRepresentationsResult.Error) fileWithRepresentationsResult).getRemoteFetchError();
        }
        throw new NoWhenBranchMatchedException();
    }
}
