package com.box.android.cpl;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [Action] */
/* JADX INFO: compiled from: Effect.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Action", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.cpl.Effect$Companion$cancel$1", f = "Effect.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class Effect$Companion$cancel$1<Action> extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $id;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Effect$Companion$cancel$1(Object obj, Continuation<? super Effect$Companion$cancel$1> continuation) {
        super(2, continuation);
        this.$id = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Effect$Companion$cancel$1(this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((Effect$Companion$cancel$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = EffectKt.cancellationLock;
            Object obj3 = this.$id;
            this.L$0 = mutex2;
            this.L$1 = obj3;
            this.label = 1;
            if (mutex2.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            obj2 = obj3;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            Set<CoroutineContext> setRemove = EffectKt.getCancellationCancellables().remove(obj2);
            if (setRemove != null) {
                Iterator<T> it = setRemove.iterator();
                while (it.hasNext()) {
                    JobKt__JobKt.cancel$default((CoroutineContext) it.next(), (CancellationException) null, 1, (Object) null);
                }
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}
