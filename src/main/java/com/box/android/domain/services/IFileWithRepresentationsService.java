package com.box.android.domain.services;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IFileWithRepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IFileWithRepresentationsService;", "", "fetchFileWithRepresentations", "Lcom/box/android/domain/services/FileWithRepresentationsResult;", "itemId", "Lcom/box/android/domain/models/ItemId;", "forOffline", "", "(Lcom/box/android/domain/models/ItemId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFileWithRepresentationsService {
    Object fetchFileWithRepresentations(ItemId itemId, boolean z, Continuation<? super FileWithRepresentationsResult> continuation);

    /* JADX INFO: compiled from: IFileWithRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object fetchFileWithRepresentations$default(IFileWithRepresentationsService iFileWithRepresentationsService, ItemId itemId, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchFileWithRepresentations");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return iFileWithRepresentationsService.fetchFileWithRepresentations(itemId, z, continuation);
    }
}
