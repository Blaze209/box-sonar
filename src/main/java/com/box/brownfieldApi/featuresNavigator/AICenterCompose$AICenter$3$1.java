package com.box.brownfieldApi.featuresNavigator;

import androidx.compose.runtime.State;
import com.margelo.nitro.boxcontext.MessengerBus;
import com.margelo.nitro.boxcontext.MessengerEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$3$1", f = "AICenterCompose.kt", i = {}, l = {510}, m = "invokeSuspend", n = {}, s = {})
final class AICenterCompose$AICenter$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnClose$delegate;
    final /* synthetic */ AiCenterViewHolder $viewHolder;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AICenterCompose$AICenter$3$1(AiCenterViewHolder aiCenterViewHolder, State<? extends Function0<Unit>> state, Continuation<? super AICenterCompose$AICenter$3$1> continuation) {
        super(2, continuation);
        this.$viewHolder = aiCenterViewHolder;
        this.$currentOnClose$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AICenterCompose$AICenter$3$1(this.$viewHolder, this.$currentOnClose$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AICenterCompose$AICenter$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<MessengerEvent> flowMessages = MessengerBus.INSTANCE.messages(this.$viewHolder.getRecipientId(), "ai_center_close_requested");
            final State<Function0<Unit>> state = this.$currentOnClose$delegate;
            this.label = 1;
            if (flowMessages.collect(new FlowCollector() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$3$1.1
                public final Object emit(MessengerEvent messengerEvent, Continuation<? super Unit> continuation) {
                    Function0 function0AICenter$lambda$13 = AICenterCompose.AICenter$lambda$13(state);
                    if (function0AICenter$lambda$13 != null) {
                        function0AICenter$lambda$13.invoke();
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((MessengerEvent) obj2, (Continuation<? super Unit>) continuation);
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
