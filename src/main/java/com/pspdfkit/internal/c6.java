package com.pspdfkit.internal;

import com.pspdfkit.ui.audio.AudioPlaybackController;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.audio.playback.AudioPlaybackControllerImpl$notifyAudioPlaybackReady$1", f = "AudioPlaybackControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class c6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ i6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c6(i6 i6Var, Continuation<? super c6> continuation) {
        super(2, continuation);
        this.a = i6Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c6(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new c6(this.a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        i6 i6Var = this.a;
        Iterator<AudioPlaybackController.AudioPlaybackListener> it = i6Var.b.iterator();
        while (it.hasNext()) {
            it.next().onReady(i6Var);
        }
        return Unit.INSTANCE;
    }
}
