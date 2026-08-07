package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1", f = "CollectionItemsListReducer.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<CollectionItemsListReducer.Action> $$this$channelFlow;
    final /* synthetic */ LiveData<PagedList<ItemModel>> $itemsLiveData;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1(LiveData<PagedList<ItemModel>> liveData, ProducerScope<? super CollectionItemsListReducer.Action> producerScope, Continuation<? super CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1> continuation) {
        super(2, continuation);
        this.$itemsLiveData = liveData;
        this.$$this$channelFlow = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1(this.$itemsLiveData, this.$$this$channelFlow, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowAsFlow = FlowLiveDataConversions.asFlow(this.$itemsLiveData);
            final ProducerScope<CollectionItemsListReducer.Action> producerScope = this.$$this$channelFlow;
            this.label = 1;
            if (flowAsFlow.collect(new FlowCollector() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceLoadItems$effect$1$1$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((PagedList<ItemModel>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(PagedList<ItemModel> pagedList, Continuation<? super Unit> continuation) {
                    Object objSend = producerScope.send(new CollectionItemsListReducer.Action.ItemsLoaded(pagedList), continuation);
                    return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
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
        return Unit.INSTANCE;
    }
}
