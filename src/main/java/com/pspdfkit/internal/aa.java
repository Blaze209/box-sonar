package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.CompoundEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.CompoundEditUndoExecutor", f = "CompoundEditUndoExecutor.kt", i = {0, 0, 0, 0, 0, 0}, l = {29}, m = "performUndo", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT, "$this$forEach$iv", "element$iv", "child", "$i$f$forEach", "$i$a$-forEach-CompoundEditUndoExecutor$performUndo$2"}, nl = {30}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 2)
public final class aa extends ContinuationImpl {
    public Object a;
    public Object b;
    public Iterator c;
    public Object d;
    public Object e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ ba h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(ba baVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = baVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.b((CompoundEdit) null, (ContinuationImpl) this);
    }
}
