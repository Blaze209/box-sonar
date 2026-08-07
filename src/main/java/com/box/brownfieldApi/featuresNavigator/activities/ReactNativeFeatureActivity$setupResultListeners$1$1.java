package com.box.brownfieldApi.featuresNavigator.activities;

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

/* JADX INFO: compiled from: ReactNativeFeatureActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity$setupResultListeners$1$1", f = "ReactNativeFeatureActivity.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
final class ReactNativeFeatureActivity$setupResultListeners$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $topic;
    int label;
    final /* synthetic */ ReactNativeFeatureActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReactNativeFeatureActivity$setupResultListeners$1$1(ReactNativeFeatureActivity reactNativeFeatureActivity, String str, Continuation<? super ReactNativeFeatureActivity$setupResultListeners$1$1> continuation) {
        super(2, continuation);
        this.this$0 = reactNativeFeatureActivity;
        this.$topic = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReactNativeFeatureActivity$setupResultListeners$1$1(this.this$0, this.$topic, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReactNativeFeatureActivity$setupResultListeners$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = MessengerBus.INSTANCE.getResult(this.this$0.getRecipientId(), this.$topic, this);
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
            this.this$0.onResultEvent(this.$topic, messengerEvent.getContent());
        }
        return Unit.INSTANCE;
    }
}
