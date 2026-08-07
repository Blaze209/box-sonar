package com.pspdfkit.internal;

import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.undo.edit.annotations.AnnotationEdit;
import com.pspdfkit.undo.edit.annotations.AudioResourceEdit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AudioResourceUndoExecutor$isSoundAnnotation$1", f = "AudioResourceUndoExecutor.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class u6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public int a;
    public final /* synthetic */ x6 b;
    public final /* synthetic */ AudioResourceEdit c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u6(x6 x6Var, AudioResourceEdit audioResourceEdit, Continuation<? super u6> continuation) {
        super(2, continuation);
        this.b = x6Var;
        this.c = audioResourceEdit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u6(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return new u6(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            x6 x6Var = this.b;
            AudioResourceEdit audioResourceEdit = this.c;
            this.a = 1;
            obj = x6Var.a((AnnotationEdit) audioResourceEdit, (ContinuationImpl) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(obj instanceof SoundAnnotation);
    }
}
