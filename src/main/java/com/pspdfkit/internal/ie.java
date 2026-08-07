package com.pspdfkit.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.document.DocumentSaver$save$1", f = "DocumentSaver.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class ie extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public int a;
    public final /* synthetic */ de b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie(de deVar, Continuation<? super ie> continuation) {
        super(2, continuation);
        this.b = deVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ie(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return new ie(this.b, continuation).invokeSuspend(Unit.INSTANCE);
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
        de deVar = this.b;
        this.a = 1;
        Object objA = de.a(deVar, this);
        return objA == coroutine_suspended ? coroutine_suspended : objA;
    }
}
