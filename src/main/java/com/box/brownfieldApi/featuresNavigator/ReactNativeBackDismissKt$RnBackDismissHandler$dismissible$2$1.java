package com.box.brownfieldApi.featuresNavigator;

import androidx.compose.runtime.ProduceStateScope;
import com.margelo.nitro.boxcontext.MessengerBus;
import com.margelo.nitro.boxcontext.MessengerEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ReactNativeBackDismiss.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/ProduceStateScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.box.brownfieldApi.featuresNavigator.ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1", f = "ReactNativeBackDismiss.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
final class ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recipientId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1(String str, Continuation<? super ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1> continuation) {
        super(2, continuation);
        this.$recipientId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1 reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1 = new ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1(this.$recipientId, continuation);
        reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1.L$0 = obj;
        return reactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProduceStateScope<Boolean> produceStateScope, Continuation<? super Unit> continuation) {
        return ((ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            this.label = 1;
            if (MessengerBus.INSTANCE.messages(this.$recipientId, ReactNativeBackDismissKt.TOPIC_BACK_DISMISSIBLE).collect(new FlowCollector() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeBackDismissKt$RnBackDismissHandler$dismissible$2$1.1
                public final Object emit(MessengerEvent messengerEvent, Continuation<? super Unit> continuation) {
                    produceStateScope.setValue(Boxing.boxBoolean(Intrinsics.areEqual(messengerEvent.getContent(), "1")));
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
