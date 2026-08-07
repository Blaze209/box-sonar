package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.forms.TextFormElementView", f = "TextFormElementView.kt", i = {0, 0}, l = {375}, m = "updateFormElementSuspending", n = {"newText", "element"}, nl = {376}, s = {"L$0", "L$1"}, v = 2)
public final class r50 extends ContinuationImpl {
    public Object a;
    public /* synthetic */ Object b;
    public final /* synthetic */ q50 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r50(q50 q50Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = q50Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        q50 q50Var = this.c;
        int i = q50.O;
        return q50Var.a((String) null, this);
    }
}
