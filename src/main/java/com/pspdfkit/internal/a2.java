package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import external.sdk.pendo.io.mozilla.javascript.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.editors.AnnotationEditorFragment$getAnnotation$2", f = "AnnotationEditorFragment.kt", i = {}, l = {Context.VERSION_1_7}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class a2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
    public int a;
    public final /* synthetic */ c2 b;
    public final /* synthetic */ lm c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2(c2 c2Var, lm lmVar, Continuation<? super a2> continuation) {
        super(2, continuation);
        this.b = c2Var;
        this.c = lmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a2(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
        return new a2(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            wu wuVar = this.b.b;
            if (wuVar == null) {
                return null;
            }
            lm lmVar = this.c;
            this.a = 1;
            obj = wuVar.a(lmVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (Annotation) obj;
    }
}
