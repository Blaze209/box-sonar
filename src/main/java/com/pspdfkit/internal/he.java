package com.pspdfkit.internal;

import com.pspdfkit.document.DocumentSaveOptions;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.document.DocumentSaver$executeSave$saveOptions$1", f = "DocumentSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class he extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DocumentSaveOptions>, Object> {
    public final /* synthetic */ de a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he(de deVar, Continuation<? super he> continuation) {
        super(2, continuation);
        this.a = deVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new he(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DocumentSaveOptions> continuation) {
        return new he(this.a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return this.a.a.a(true);
    }
}
