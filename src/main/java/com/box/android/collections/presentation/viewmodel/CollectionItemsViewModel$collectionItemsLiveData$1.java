package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataScope;
import androidx.paging.PagedList;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.collections.ListCollectionItemsUseCase;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CollectionItemsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/item/ItemModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel$collectionItemsLiveData$1", f = "CollectionItemsViewModel.kt", i = {0}, l = {38}, m = "invokeSuspend", n = {"$this$liveData"}, s = {"L$0"}, v = 1)
final class CollectionItemsViewModel$collectionItemsLiveData$1 extends SuspendLambda implements Function2<LiveDataScope<PagedList<ItemModel>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CollectionItemsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionItemsViewModel$collectionItemsLiveData$1(CollectionItemsViewModel collectionItemsViewModel, Continuation<? super CollectionItemsViewModel$collectionItemsLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionItemsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CollectionItemsViewModel$collectionItemsLiveData$1 collectionItemsViewModel$collectionItemsLiveData$1 = new CollectionItemsViewModel$collectionItemsLiveData$1(this.this$0, continuation);
        collectionItemsViewModel$collectionItemsLiveData$1.L$0 = obj;
        return collectionItemsViewModel$collectionItemsLiveData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LiveDataScope<PagedList<ItemModel>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemsViewModel$collectionItemsLiveData$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.initialFetchCompleted = false;
            Flow flowListCollectionItems$default = ListCollectionItemsUseCase.listCollectionItems$default(this.this$0.listCollectionItemsInteractor, this.this$0.collectionId, 0, 2, null);
            final CollectionItemsViewModel collectionItemsViewModel = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(liveDataScope);
            this.label = 1;
            if (flowListCollectionItems$default.collect(new FlowCollector() { // from class: com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel$collectionItemsLiveData$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>> result, Continuation<? super Unit> continuation) {
                    LiveData<PagedList<ItemModel>> liveData;
                    Object objEmitSource;
                    if (result instanceof Result.Success) {
                        liveData = (LiveData) ((Result.Success) result).getValue();
                    } else {
                        if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DomainError.CachedDomainError cachedDomainError = (DomainError.CachedDomainError) ((Result.Error) result).getValue();
                        collectionItemsViewModel.get_errorLiveData().setValue(collectionItemsViewModel.errorHelper(cachedDomainError.getError()));
                        liveData = (LiveData) cachedDomainError.getCache();
                    }
                    return (liveData == null || (objEmitSource = liveDataScope.emitSource(liveData, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objEmitSource;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.initialFetchCompleted = true;
        return Unit.INSTANCE;
    }
}
