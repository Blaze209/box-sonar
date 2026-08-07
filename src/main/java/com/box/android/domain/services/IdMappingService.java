package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IdMappingService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IdMappingService;", "", "getRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "id", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteIdOrError", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "observeRemoteId", "Lkotlinx/coroutines/flow/Flow;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IdMappingService {
    Object getRemoteId(ItemId itemId, Continuation<? super ItemId.Remote> continuation);

    Object getRemoteIdOrError(ItemId itemId, Continuation<? super Result<ItemId.Remote, ? extends DomainError>> continuation);

    Flow<ItemId.Remote> observeRemoteId(ItemId id);
}
