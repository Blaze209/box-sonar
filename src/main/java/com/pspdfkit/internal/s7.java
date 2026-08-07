package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.BaseUndoExecutor", f = "BaseUndoExecutor.kt", i = {0}, l = {35}, m = "redo", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT}, nl = {36}, s = {"L$0"}, v = 2)
public final class s7 extends ContinuationImpl {
    public Edit a;
    public /* synthetic */ Object b;
    public final /* synthetic */ q7<Edit> c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s7(q7 q7Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = q7Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((Edit) null, (ContinuationImpl) this);
    }
}
