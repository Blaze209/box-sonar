package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.annotations.AnnotationZIndexEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationZIndexUndoExecutor", f = "AnnotationZIndexUndoExecutor.kt", i = {0, 0, 0}, l = {39}, m = "performRedo", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT, "$this$performRedo_u24lambda_u240", "$i$a$-runCatching-AnnotationZIndexUndoExecutor$performRedo$2"}, nl = {44}, s = {"L$0", "L$1", "I$0"}, v = 2)
public final class f5 extends ContinuationImpl {
    public Object a;
    public Object b;
    public /* synthetic */ Object c;
    public final /* synthetic */ e5 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f5(e5 e5Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = e5Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((AnnotationZIndexEdit) null, (ContinuationImpl) this);
    }
}
