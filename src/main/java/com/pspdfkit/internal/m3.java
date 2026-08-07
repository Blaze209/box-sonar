package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.annotations.AnnotationPropertyEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationPropertyUndoExecutor", f = "AnnotationPropertyUndoExecutor.kt", i = {0, 0, 0}, l = {51}, m = "performRedo", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT, "$this$performRedo_u24lambda_u240", "$i$a$-runCatching-AnnotationPropertyUndoExecutor$performRedo$2"}, nl = {52}, s = {"L$0", "L$1", "I$0"}, v = 2)
public final class m3 extends ContinuationImpl {
    public AnnotationPropertyEdit a;
    public l3 b;
    public /* synthetic */ Object c;
    public final /* synthetic */ l3 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(l3 l3Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = l3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((AnnotationPropertyEdit) null, (ContinuationImpl) this);
    }
}
