package com.pspdfkit.ui.toolbar;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1", f = "UndoRedoToolbarHelper.kt", i = {0}, l = {256}, m = "invokeSuspend", n = {"$this$launch"}, nl = {258}, s = {"L$0"}, v = 2)
public final class UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Deferred<Boolean> $canRedoDeferred;
    final /* synthetic */ Deferred<Boolean> $canUndoDeferred;
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $onStateUpdated;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UndoRedoToolbarHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1(Deferred<Boolean> deferred, Deferred<Boolean> deferred2, UndoRedoToolbarHelper undoRedoToolbarHelper, Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1> continuation) {
        super(2, continuation);
        this.$canUndoDeferred = deferred;
        this.$canRedoDeferred = deferred2;
        this.this$0 = undoRedoToolbarHelper;
        this.$onStateUpdated = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1 undoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1 = new UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1(this.$canUndoDeferred, this.$canRedoDeferred, this.this$0, this.$onStateUpdated, continuation);
        undoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1.L$0 = obj;
        return undoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (CoroutineScopeKt.isActive(coroutineScope) && (!this.$canUndoDeferred.isCompleted() || !this.$canRedoDeferred.isCompleted())) {
            this.this$0.applyButtonState(false, false);
            Function2<Boolean, Boolean, Unit> function2 = this.$onStateUpdated;
            if (function2 != null) {
                function2.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UndoRedoToolbarHelper$updateUndoRedoButtons$1$timeoutJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
