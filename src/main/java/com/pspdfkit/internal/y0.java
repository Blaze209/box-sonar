package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationAddRemoveUndoExecutor", f = "AnnotationAddRemoveUndoExecutor.kt", i = {0, 1}, l = {73, 75}, m = "performRedo", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT, SemanticAttributes.FaasDocumentOperationValues.EDIT}, nl = {75, 77}, s = {"L$0", "L$0"}, v = 2)
public final class y0 extends ContinuationImpl {
    public AnnotationAddRemoveEdit a;
    public /* synthetic */ Object b;
    public final /* synthetic */ v0 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(v0 v0Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = v0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.b((AnnotationAddRemoveEdit) null, (ContinuationImpl) this);
    }
}
