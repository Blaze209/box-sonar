package com.pspdfkit.internal;

import com.pspdfkit.ui.audio.AudioModeListeners;
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
@DebugMetadata(c = "com.pspdfkit.internal.audio.manager.AudioListenersCollection$notifyAudioRecordingModeEntered$1", f = "AudioListenersCollection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class v5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ x5 a;
    public final /* synthetic */ AudioRecordingController b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v5(x5 x5Var, AudioRecordingController audioRecordingController, Continuation<? super v5> continuation) {
        super(2, continuation);
        this.a = x5Var;
        this.b = audioRecordingController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v5(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new v5(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        go<AudioModeListeners.AudioRecordingModeChangeListener> goVar = this.a.b;
        AudioRecordingController audioRecordingController = this.b;
        Iterator<AudioModeListeners.AudioRecordingModeChangeListener> it = goVar.iterator();
        while (it.hasNext()) {
            it.next().onEnterAudioRecordingMode(audioRecordingController);
        }
        return Unit.INSTANCE;
    }
}
