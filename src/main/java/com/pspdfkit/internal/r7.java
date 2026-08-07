package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.utils.PdfLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.BaseUndoExecutor$notifyListeners$1", f = "BaseUndoExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class r7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ q7.a<Edit> a;
    public final /* synthetic */ q7<Edit> b;
    public final /* synthetic */ Edit c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r7(q7.a<Edit> aVar, q7<Edit> q7Var, Edit edit, Continuation<? super r7> continuation) {
        super(2, continuation);
        this.a = aVar;
        this.b = q7Var;
        this.c = edit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r7(this.a, this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((r7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        try {
            this.a.a(this.b, this.c);
        } catch (Exception e) {
            PdfLog.e(this.b.d, e, "UndoExecutorListener threw unexpected exception", new Object[0]);
        }
        return Unit.INSTANCE;
    }
}
