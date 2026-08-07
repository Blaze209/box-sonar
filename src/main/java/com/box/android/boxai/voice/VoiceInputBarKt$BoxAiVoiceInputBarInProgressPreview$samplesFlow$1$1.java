package com.box.android.boxai.voice;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: VoiceInputBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1", f = "VoiceInputBar.kt", i = {0}, l = {227}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1(Continuation<? super VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1 voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1 = new VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1(continuation);
        voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1.L$0 = obj;
        return voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return ((VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Float[] fArr;
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0 && i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            fArr = new Float[]{Boxing.boxFloat(0.0f), Boxing.boxFloat(0.2f), Boxing.boxFloat(0.4f), Boxing.boxFloat(0.6f), Boxing.boxFloat(0.8f), Boxing.boxFloat(1.0f)};
            this.L$0 = flowCollector;
            this.label = 1;
        } while (FlowKt.emitAll(flowCollector, FlowKt.flowOf((Object[]) fArr), this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
