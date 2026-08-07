package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getZIndex$2", f = "AnnotationProviderImpl.kt", i = {}, l = {757}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class y3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    public int a;
    public final /* synthetic */ Annotation b;
    public final /* synthetic */ o3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y3(Annotation annotation, o3 o3Var, Continuation<? super y3> continuation) {
        super(2, continuation);
        this.b = annotation;
        this.c = o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new y3(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return new y3(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.b.isAttached()) {
                this.b.getPageIndex();
            }
            o3 o3Var = this.c;
            int pageIndex = this.b.getPageIndex();
            this.a = 1;
            obj = o3Var.getAnnotations(pageIndex, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(((List) obj).indexOf(this.b));
    }
}
