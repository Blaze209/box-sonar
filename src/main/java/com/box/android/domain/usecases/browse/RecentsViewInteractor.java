package com.box.android.domain.usecases.browse;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IRecentsService;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RecentsViewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/usecases/browse/RecentsViewInteractor;", "Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "recentsService", "Lcom/box/android/domain/services/IRecentsService;", "<init>", "(Lcom/box/android/domain/services/IRecentsService;)V", "fetchItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "refreshFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsViewInteractor implements ItemsViewUseCase {
    private final IRecentsService recentsService;

    @Inject
    public RecentsViewInteractor(IRecentsService recentsService) {
        Intrinsics.checkNotNullParameter(recentsService, "recentsService");
        this.recentsService = recentsService;
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Flow<Result<List<ItemModel>, DomainError>> fetchItems(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return this.recentsService.recentItems();
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object refreshFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.recentsService.fetchRecentItemsFromRemote(continuation);
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object fetchItemsFromLegacyCache(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return FlowKt.first(fetchItems(remote), continuation);
    }
}
