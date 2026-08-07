package com.box.brownfieldApi.featuresNavigator;

import com.margelo.nitro.boxcontext.MessengerBus;
import com.margelo.nitro.boxcontext.MessengerEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ReactNativeCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$ReactNativeFeatureWidget$1$1$1", f = "ReactNativeCompose.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
final class ReactNativeCompose$ReactNativeFeatureWidget$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, String, Unit> $onResult;
    final /* synthetic */ String $recipientId;
    final /* synthetic */ String $topic;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(String str, String str2, Function2<? super String, ? super String, Unit> function2, Continuation<? super ReactNativeCompose$ReactNativeFeatureWidget$1$1$1> continuation) {
        super(2, continuation);
        this.$recipientId = str;
        this.$topic = str2;
        this.$onResult = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(this.$recipientId, this.$topic, this.$onResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReactNativeCompose$ReactNativeFeatureWidget$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = MessengerBus.INSTANCE.getResult(this.$recipientId, this.$topic, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MessengerEvent messengerEvent = (MessengerEvent) obj;
        if (Intrinsics.areEqual(messengerEvent.getStatus(), MessengerBus.STATUS_OK)) {
            this.$onResult.invoke(this.$topic, messengerEvent.getContent());
        }
        return Unit.INSTANCE;
    }
}
