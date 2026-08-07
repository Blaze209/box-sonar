package com.pspdfkit.internal;

import com.pspdfkit.annotations.SoundAnnotation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.audio.playback.AudioPlaybackControllerImpl$setSoundAnnotationState$1", f = "AudioPlaybackControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class g6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ SoundAnnotation a;
    public final /* synthetic */ j30 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g6(SoundAnnotation soundAnnotation, j30 j30Var, Continuation<? super g6> continuation) {
        super(2, continuation);
        this.a = soundAnnotation;
        this.b = j30Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g6(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new g6(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        o3 annotationProvider;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (this.a.getInternal().getSoundAnnotationState() != this.b) {
            this.a.getInternal().setSoundAnnotationState(this.b);
            lm internalDocument = this.a.getInternal().getInternalDocument();
            if (internalDocument != null && (annotationProvider = internalDocument.getAnnotationProvider()) != null) {
                annotationProvider.e(this.a);
            }
        }
        return Unit.INSTANCE;
    }
}
