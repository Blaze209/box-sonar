package com.box.android.boxai.voice;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: VoiceInputBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2", f = "VoiceInputBar.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
    int label;

    VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2(Continuation<? super VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2(continuation);
    }

    public final Object invoke(float f, Continuation<? super Unit> continuation) {
        return ((VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$2) create(Float.valueOf(f), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Float f, Continuation<? super Unit> continuation) {
        return invoke(f.floatValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Duration.Companion companion = Duration.INSTANCE;
            this.label = 1;
            if (DelayKt.m16309delayVtjQ1oo(DurationKt.toDuration(100, DurationUnit.MILLISECONDS), this) == coroutine_suspended) {
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
