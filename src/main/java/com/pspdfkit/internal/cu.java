package com.pspdfkit.internal;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.PageLayout$loadAnnotations$1", f = "PageLayout.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, nl = {778}, s = {}, v = 2)
public final class cu extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ m40 b;
    public final /* synthetic */ au c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(m40 m40Var, au auVar, Continuation<? super cu> continuation) {
        super(2, continuation);
        this.b = m40Var;
        this.c = auVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new cu(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new cu(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 annotationProvider = this.b.a.getAnnotationProvider();
                int i2 = this.b.b;
                this.a = 1;
                obj = annotationProvider.getAnnotations(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            au.a(this.c, (List) obj);
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
