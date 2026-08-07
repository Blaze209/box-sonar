package com.box.android.browse.cpl.itemsList;

import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$reduceItemsList$effect$1$1", f = "ActionableItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ActionableItemsListReducer$reduceItemsList$effect$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FolderModel $it;
    int label;
    final /* synthetic */ ActionableItemsListReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActionableItemsListReducer$reduceItemsList$effect$1$1(ActionableItemsListReducer actionableItemsListReducer, FolderModel folderModel, Continuation<? super ActionableItemsListReducer$reduceItemsList$effect$1$1> continuation) {
        super(1, continuation);
        this.this$0 = actionableItemsListReducer;
        this.$it = folderModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ActionableItemsListReducer$reduceItemsList$effect$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ActionableItemsListReducer$reduceItemsList$effect$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.environment.getBrowseAnalytics().sendSelectFolderTriggered(this.$it);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
