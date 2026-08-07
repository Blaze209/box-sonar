package com.box.android.preview.iteminformation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationReducer$build$1$effect$1", f = "ItemInformationReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemInformationReducer$build$1$effect$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemInformationReducer.State $state;
    int label;
    final /* synthetic */ ItemInformationReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemInformationReducer$build$1$effect$1(ItemInformationReducer itemInformationReducer, ItemInformationReducer.State state, Continuation<? super ItemInformationReducer$build$1$effect$1> continuation) {
        super(1, continuation);
        this.this$0 = itemInformationReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ItemInformationReducer$build$1$effect$1(this.this$0, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ItemInformationReducer$build$1$effect$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getEnvironment().getAnalytics().collaboratorsTriggered(this.$state.getItemModel());
        return Unit.INSTANCE;
    }
}
