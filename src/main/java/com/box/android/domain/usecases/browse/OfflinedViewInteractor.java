package com.box.android.domain.usecases.browse;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.utils.result.Result;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: OfflinedViewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J \u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0086@¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;", "Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "<init>", "(Lcom/box/android/domain/services/IOfflineService;)V", "fetchItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "refreshFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "getOutdatedItems", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineItems", AlertFragment.ARG_ITEMS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflinedViewInteractor implements ItemsViewUseCase {
    private final IOfflineService offlineService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.browse.OfflinedViewInteractor$refreshFromRemote$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflinedViewInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.browse.OfflinedViewInteractor", f = "OfflinedViewInteractor.kt", i = {0}, l = {16}, m = "refreshFromRemote", n = {"folderId"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflinedViewInteractor.this.refreshFromRemote(null, this);
        }
    }

    @Inject
    public OfflinedViewInteractor(IOfflineService offlineService) {
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        this.offlineService = offlineService;
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Flow<Result<List<ItemModel>, DomainError>> fetchItems(ItemId.Remote folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return this.offlineService.offlineItems();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object refreshFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object outdatedOfflineItems = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(outdatedOfflineItems);
            IOfflineService iOfflineService = this.offlineService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(remote);
            anonymousClass1.label = 1;
            outdatedOfflineItems = iOfflineService.getOutdatedOfflineItems(anonymousClass1);
            if (outdatedOfflineItems == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(outdatedOfflineItems);
        }
        Result result = (Result) outdatedOfflineItems;
        if (result instanceof Result.Success) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.usecases.browse.ItemsViewUseCase
    public Object fetchItemsFromLegacyCache(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return new Result.Error(new DomainError.CacheReadError("Not supported operation"));
    }

    public final Object getOutdatedItems(Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation) {
        return this.offlineService.getOutdatedOfflineItems(continuation);
    }

    public final Object syncOfflineItems(List<? extends ItemModel> list, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.offlineService.syncOfflineItems(list, continuation);
    }
}
