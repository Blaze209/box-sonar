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
@DebugMetadata(c = "com.pspdfkit.internal.audio.playback.AudioPlaybackControllerImpl$notifyAudioPlaybackError$1", f = "AudioPlaybackControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class z5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ i6 a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z5(i6 i6Var, Throwable th, Continuation<? super z5> continuation) {
        super(2, continuation);
        this.a = i6Var;
        this.b = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new z5(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new z5(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        i6 i6Var = this.a;
        go<AudioPlaybackController.AudioPlaybackListener> goVar = i6Var.b;
        Throwable th = this.b;
        Iterator<AudioPlaybackController.AudioPlaybackListener> it = goVar.iterator();
        while (it.hasNext()) {
            it.next().onError(i6Var, th);
        }
        return Unit.INSTANCE;
    }
}
