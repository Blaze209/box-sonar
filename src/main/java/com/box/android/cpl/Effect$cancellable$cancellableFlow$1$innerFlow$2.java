package com.box.android.cpl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [Action] */
/* JADX INFO: compiled from: Effect.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Action", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.cpl.Effect$cancellable$cancellableFlow$1$innerFlow$2", f = "Effect.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
final class Effect$cancellable$cancellableFlow$1$innerFlow$2<Action> extends SuspendLambda implements Function2<Action, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<Action> $$this$flow;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Effect$cancellable$cancellableFlow$1$innerFlow$2(FlowCollector<? super Action> flowCollector, Continuation<? super Effect$cancellable$cancellableFlow$1$innerFlow$2> continuation) {
        super(2, continuation);
        this.$$this$flow = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Effect$cancellable$cancellableFlow$1$innerFlow$2 effect$cancellable$cancellableFlow$1$innerFlow$2 = new Effect$cancellable$cancellableFlow$1$innerFlow$2(this.$$this$flow, continuation);
        effect$cancellable$cancellableFlow$1$innerFlow$2.L$0 = obj;
        return effect$cancellable$cancellableFlow$1$innerFlow$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Action action, Continuation<? super Unit> continuation) {
        return ((Effect$cancellable$cancellableFlow$1$innerFlow$2) create(action, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            FlowCollector<Action> flowCollector = this.$$this$flow;
            this.label = 1;
            if (flowCollector.emit((Action) obj2, this) == coroutine_suspended) {
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
