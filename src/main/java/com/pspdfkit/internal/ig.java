package com.pspdfkit.internal;

import com.pspdfkit.annotations.InkAnnotation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.EraserAnnotationModeHandler$saveAnnotations$1$1", f = "EraserAnnotationModeHandler.kt", i = {}, l = {474}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class ig extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ o3 b;
    public final /* synthetic */ InkAnnotation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig(o3 o3Var, InkAnnotation inkAnnotation, Continuation<? super ig> continuation) {
        super(2, continuation);
        this.b = o3Var;
        this.c = inkAnnotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ig(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new ig(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            o3 o3Var = this.b;
            InkAnnotation inkAnnotation = this.c;
            this.a = 1;
            if (o3Var.removeAnnotationFromPage(inkAnnotation, this) == coroutine_suspended) {
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
