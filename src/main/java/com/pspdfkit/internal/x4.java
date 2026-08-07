package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.annotations.AnnotationEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationUndoExecutor", f = "AnnotationUndoExecutor.kt", i = {0}, l = {31}, m = "retrieveEditedAnnotation", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT}, nl = {32}, s = {"L$0"}, v = 2)
public final class x4 extends ContinuationImpl {
    public AnnotationEdit a;
    public /* synthetic */ Object b;
    public final /* synthetic */ y4<AnnotationEdit> c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x4(y4 y4Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = y4Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((AnnotationEdit) null, (ContinuationImpl) this);
    }
}
