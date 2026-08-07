package com.box.android.base.cpl;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ItemActionConfirmationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.cpl.ItemActionConfirmationReducer$build$1$1", f = "ItemActionConfirmationReducer.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemActionConfirmationReducer$build$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ItemId, Continuation<? super Unit>, Object> $actionToPerformOnConfirmation;
    final /* synthetic */ ItemActionConfirmationReducer.State $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ItemActionConfirmationReducer$build$1$1(Function2<? super ItemId, ? super Continuation<? super Unit>, ? extends Object> function2, ItemActionConfirmationReducer.State state, Continuation<? super ItemActionConfirmationReducer$build$1$1> continuation) {
        super(1, continuation);
        this.$actionToPerformOnConfirmation = function2;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ItemActionConfirmationReducer$build$1$1(this.$actionToPerformOnConfirmation, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ItemActionConfirmationReducer$build$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ItemId, Continuation<? super Unit>, Object> function2 = this.$actionToPerformOnConfirmation;
            ItemId itemId = this.$state.getItemModel().getItemId();
            this.label = 1;
            if (function2.invoke(itemId, this) == coroutine_suspended) {
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
