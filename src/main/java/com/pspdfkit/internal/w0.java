package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AnnotationAddRemoveUndoExecutor", f = "AnnotationAddRemoveUndoExecutor.kt", i = {0, 0, 0}, l = {91}, m = "addAnnotation", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT, "newAnnotation", "originalObjectNumber"}, nl = {92}, s = {"L$0", "L$1", "I$0"}, v = 2)
public final class w0 extends ContinuationImpl {
    public Object a;
    public Annotation b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ v0 e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(v0 v0Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = v0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a((AnnotationAddRemoveEdit) null, (ContinuationImpl) this);
    }
}
