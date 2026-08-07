package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.SoundAnnotation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.audio.playback.AudioPlaybackControllerImpl$setState$1", f = "AudioPlaybackControllerImpl.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, nl = {124}, s = {}, v = 2)
public final class h6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ y6 b;
    public final /* synthetic */ lm c;
    public final /* synthetic */ i6 d;
    public final /* synthetic */ Context e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h6(y6 y6Var, lm lmVar, i6 i6Var, Context context, Continuation<? super h6> continuation) {
        super(2, continuation);
        this.b = y6Var;
        this.c = lmVar;
        this.d = i6Var;
        this.e = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new h6(this.b, this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((h6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            y6 y6Var = this.b;
            lm lmVar = this.c;
            this.a = 1;
            obj = y6Var.a(lmVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SoundAnnotation soundAnnotation = (SoundAnnotation) obj;
        if (soundAnnotation == null) {
            return Unit.INSTANCE;
        }
        boolean zAreEqual = Intrinsics.areEqual(soundAnnotation, this.d.c);
        i6 i6Var = this.d;
        if (zAreEqual) {
            x5 x5Var = i6Var.a.a;
            x5Var.getClass();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new s5(x5Var, i6Var, null), 3, null);
            if (this.d.isReady()) {
                i6 i6Var2 = this.d;
                i6Var2.getClass();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new c6(i6Var2, null), 3, null);
            }
        } else {
            Context context = this.e;
            y6 y6Var2 = this.b;
            i6Var.a(context, soundAnnotation, y6Var2.b, y6Var2.d);
        }
        return Unit.INSTANCE;
    }
}
