package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.collections.ListCollectionItemsUseCase;
import com.box.android.domain.utils.result.Result;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceLoadItems$effect$1", f = "CollectionItemsListReducer.kt", i = {0, 0}, l = {191}, m = "invokeSuspend", n = {"$this$channelFlow", "itemsLiveDataJob"}, s = {"L$0", "L$1"}, v = 1)
final class CollectionItemsListReducer$reduceLoadItems$effect$1 extends SuspendLambda implements Function2<ProducerScope<? super CollectionItemsListReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CollectionItemsListReducer.State $state;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CollectionItemsListReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionItemsListReducer$reduceLoadItems$effect$1(CollectionItemsListReducer collectionItemsListReducer, CollectionItemsListReducer.State state, Continuation<? super CollectionItemsListReducer$reduceLoadItems$effect$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionItemsListReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CollectionItemsListReducer$reduceLoadItems$effect$1 collectionItemsListReducer$reduceLoadItems$effect$1 = new CollectionItemsListReducer$reduceLoadItems$effect$1(this.this$0, this.$state, continuation);
        collectionItemsListReducer$reduceLoadItems$effect$1.L$0 = obj;
        return collectionItemsListReducer$reduceLoadItems$effect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super CollectionItemsListReducer.Action> producerScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemsListReducer$reduceLoadItems$effect$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
            this.label = 1;
            if (ListCollectionItemsUseCase.listCollectionItems$default(this.this$0.environment.getListCollectionItemsInteractor(), this.$state.getCollectionId(), 0, 2, null).collect(new AnonymousClass1(objectRef, producerScope), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceLoadItems$effect$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<CollectionItemsListReducer.Action> $$this$channelFlow;
        final /* synthetic */ Ref.ObjectRef<Job> $itemsLiveDataJob;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<Job> objectRef, ProducerScope<? super CollectionItemsListReducer.Action> producerScope) {
            this.$itemsLiveDataJob = objectRef;
            this.$$this$channelFlow = producerScope;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        public final Object emit(Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>> result, Continuation<? super Unit> continuation) {
            CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1 collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1;
            if (continuation instanceof CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1) {
                collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1 = (CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1) continuation;
                if ((collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1 = new CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1(this, continuation);
                }
            } else {
                collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1 = new CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1(this, continuation);
            }
            Object obj = collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<Job> objectRef = this.$itemsLiveDataJob;
                ProducerScope<CollectionItemsListReducer.Action> producerScope = this.$$this$channelFlow;
                boolean z = result instanceof Result.Success;
                if (z) {
                    LiveData liveData = (LiveData) ((Result.Success) result).getValue();
                    Job job = objectRef.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    objectRef.element = (T) BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1(liveData, producerScope, null), 3, null);
                } else if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                ProducerScope<CollectionItemsListReducer.Action> producerScope2 = this.$$this$channelFlow;
                if (!z) {
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainError.CachedDomainError cachedDomainError = (DomainError.CachedDomainError) ((Result.Error) result).getValue();
                    CollectionItemsListReducer.Action.LoadFailed loadFailed = new CollectionItemsListReducer.Action.LoadFailed(DomainErrorKt.unwrapCachedDomainError(cachedDomainError));
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(result);
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.L$1 = result;
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(cachedDomainError);
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.I$0 = 0;
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.I$1 = 0;
                    collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.label = 1;
                    if (producerScope2.send(loadFailed, collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.I$1;
                int i3 = collectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1.I$0;
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>) obj, (Continuation<? super Unit>) continuation);
        }
    }
}
