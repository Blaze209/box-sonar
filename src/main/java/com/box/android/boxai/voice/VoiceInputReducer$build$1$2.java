package com.box.android.boxai.voice;

import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: VoiceInputReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/voice/VoiceInputReducer$Action$RecognitionError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputReducer$build$1$2", f = "VoiceInputReducer.kt", i = {0, 0, 0, 0, 0}, l = {123}, m = "invokeSuspend", n = {"$this$flow", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-VoiceInputReducer$build$1$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class VoiceInputReducer$build$1$2 extends SuspendLambda implements Function2<FlowCollector<? super VoiceInputReducer.Action.RecognitionError>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VoiceInputReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VoiceInputReducer$build$1$2(VoiceInputReducer voiceInputReducer, Continuation<? super VoiceInputReducer$build$1$2> continuation) {
        super(2, continuation);
        this.this$0 = voiceInputReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VoiceInputReducer$build$1$2 voiceInputReducer$build$1$2 = new VoiceInputReducer$build$1$2(this.this$0, continuation);
        voiceInputReducer$build$1$2.L$0 = obj;
        return voiceInputReducer$build$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super VoiceInputReducer.Action.RecognitionError> flowCollector, Continuation<? super Unit> continuation) {
        return ((VoiceInputReducer$build$1$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Result<Unit, RecognitionError> resultFinishListening = this.this$0.environment.getSpeechRecognitionManager().finishListening();
            if (!(resultFinishListening instanceof Result.Success)) {
                if (resultFinishListening instanceof Result.Error) {
                    RecognitionError recognitionError = (RecognitionError) ((Result.Error) resultFinishListening).getValue();
                    VoiceInputReducer.Action.RecognitionError recognitionError2 = VoiceInputReducer.Action.RecognitionError.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(resultFinishListening);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(recognitionError);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (flowCollector.emit(recognitionError2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        new Result.Error(Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}
