package com.pspdfkit.internal;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationAddRemoveUndoExecutor", f = "AnnotationAddRemoveUndoExecutor.kt", i = {0, 1, 1}, l = {103, 104}, m = "removeAnnotation", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT, SemanticAttributes.FaasDocumentOperationValues.EDIT, "annotation"}, nl = {104, 105}, s = {"L$0", "L$0", "L$1"}, v = 2)
public final class a1 extends ContinuationImpl {
    public Object a;
    public Object b;
    public /* synthetic */ Object c;
    public final /* synthetic */ v0 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(v0 v0Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = v0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.d(null, this);
    }
}
