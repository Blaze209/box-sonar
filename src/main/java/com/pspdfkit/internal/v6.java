package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.annotations.AudioResourceEdit;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.undo.annotations.AudioResourceUndoExecutor", f = "AudioResourceUndoExecutor.kt", i = {0}, l = {52}, m = "performRedo", n = {SemanticAttributes.FaasDocumentOperationValues.EDIT}, nl = {53}, s = {"L$0"}, v = 2)
public final class v6 extends ContinuationImpl {
    public AudioResourceEdit a;
    public /* synthetic */ Object b;
    public final /* synthetic */ x6 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v6(x6 x6Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = x6Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((AudioResourceEdit) null, (ContinuationImpl) this);
    }
}
