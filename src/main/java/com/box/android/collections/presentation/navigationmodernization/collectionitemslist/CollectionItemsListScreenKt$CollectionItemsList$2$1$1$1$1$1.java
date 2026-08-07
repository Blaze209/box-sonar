package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionItemsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1", f = "CollectionItemsListScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemReducer.State $item;
    final /* synthetic */ Function1<CollectionItemsListReducer.Action, Unit> $sendAction;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1(Function1<? super CollectionItemsListReducer.Action, Unit> function1, ItemReducer.State state, Continuation<? super CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$sendAction = function1;
        this.$item = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1(this.$sendAction, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$sendAction.invoke(new CollectionItemsListReducer.Action.ItemAction(this.$item.getId(), new ItemReducer.Action.ThumbnailAction(ItemThumbnailReducer.Action.FetchThumbnail.INSTANCE)));
        return Unit.INSTANCE;
    }
}
