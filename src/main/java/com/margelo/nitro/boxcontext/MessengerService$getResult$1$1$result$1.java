package com.margelo.nitro.boxcontext;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MessengerService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/margelo/nitro/boxcontext/MessengerEvent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.margelo.nitro.boxcontext.MessengerService$getResult$1$1$result$1", f = "MessengerService.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class MessengerService$getResult$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MessengerEvent>, Object> {
    final /* synthetic */ String $recipientId;
    final /* synthetic */ String $resultTopic;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MessengerService$getResult$1$1$result$1(String str, String str2, Continuation<? super MessengerService$getResult$1$1$result$1> continuation) {
        super(2, continuation);
        this.$recipientId = str;
        this.$resultTopic = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessengerService$getResult$1$1$result$1(this.$recipientId, this.$resultTopic, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MessengerEvent> continuation) {
        return ((MessengerService$getResult$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object result = MessengerBus.INSTANCE.getResult(this.$recipientId, this.$resultTopic, this);
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
