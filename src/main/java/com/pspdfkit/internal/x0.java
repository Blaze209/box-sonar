package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import external.sdk.pendo.io.mozilla.javascript.Token;
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
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationAddRemoveUndoExecutor$doesAnnotationExistOnDocument$1", f = "AnnotationAddRemoveUndoExecutor.kt", i = {}, l = {Token.SETELEM_OP}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class x0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public int a;
    public final /* synthetic */ v0 b;
    public final /* synthetic */ AnnotationAddRemoveEdit c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(v0 v0Var, AnnotationAddRemoveEdit annotationAddRemoveEdit, Continuation<? super x0> continuation) {
        super(2, continuation);
        this.b = v0Var;
        this.c = annotationAddRemoveEdit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new x0(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return new x0(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            v0 v0Var = this.b;
            AnnotationAddRemoveEdit annotationAddRemoveEdit = this.c;
            this.a = 1;
            o3 o3Var = v0Var.e;
            int pageIndex = annotationAddRemoveEdit.getPageIndex();
            int objectNumber = annotationAddRemoveEdit.getObjectNumber();
            while (true) {
                int i2 = v0Var.f.get(objectNumber, objectNumber);
                if (i2 == objectNumber) {
                    break;
                }
                objectNumber = i2;
            }
            o3Var.getClass();
            obj = o3.a(o3Var, pageIndex, objectNumber, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(obj != null);
    }
}
