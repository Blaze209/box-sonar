package com.box.android.boxai.voice;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: VoiceInputBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "", "acc", "value"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.voice.VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3", f = "VoiceInputBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3 extends SuspendLambda implements Function3<List<? extends Float>, Float, Continuation<? super List<? extends Float>>, Object> {
    /* synthetic */ float F$0;
    /* synthetic */ Object L$0;
    int label;

    VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3(Continuation<? super VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Float> list, Float f, Continuation<? super List<? extends Float>> continuation) {
        return invoke((List<Float>) list, f.floatValue(), (Continuation<? super List<Float>>) continuation);
    }

    public final Object invoke(List<Float> list, float f, Continuation<? super List<Float>> continuation) {
        VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3 voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3 = new VoiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3(continuation);
        voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3.L$0 = list;
        voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3.F$0 = f;
        return voiceInputBarKt$BoxAiVoiceInputBarInProgressPreview$samplesFlow$1$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        float f = this.F$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return CollectionsKt.plus((Collection<? extends Float>) list, Boxing.boxFloat(f));
    }
}
