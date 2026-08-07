package com.pspdfkit.internal;

import com.pspdfkit.ui.audio.AudioRecordingController;
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
@DebugMetadata(c = "com.pspdfkit.internal.audio.recording.AudioRecordingControllerImpl$notifyAudioRecordingError$1", f = "AudioRecordingControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class m6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ t6 a;
    public final /* synthetic */ Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m6(t6 t6Var, Throwable th, Continuation<? super m6> continuation) {
        super(2, continuation);
        this.a = t6Var;
        this.b = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m6(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new m6(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        t6 t6Var = this.a;
        go<AudioRecordingController.AudioRecordingListener> goVar = t6Var.c;
        Throwable th = this.b;
        Iterator<AudioRecordingController.AudioRecordingListener> it = goVar.iterator();
        while (it.hasNext()) {
            it.next().onError(t6Var, th);
        }
        return Unit.INSTANCE;
    }
}
