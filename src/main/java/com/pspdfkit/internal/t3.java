package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getFlattenedAnnotationReplies$2", f = "AnnotationProviderImpl.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class t3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
    public int a;
    public final /* synthetic */ o3 b;
    public final /* synthetic */ Annotation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t3(o3 o3Var, Annotation annotation, Continuation<? super t3> continuation) {
        super(2, continuation);
        this.b = o3Var;
        this.c = annotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new t3(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
        return new t3(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        o3 o3Var = this.b;
        Annotation annotation = this.c;
        this.a = 1;
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new u3(false, o3Var, annotation, null), this);
        return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
    }
}
