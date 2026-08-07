package com.pspdfkit.internal;

import com.pspdfkit.forms.FormElement;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.FormEditor", f = "FormEditor.kt", i = {0, 0}, l = {388}, m = "cleanupView", n = {"view", "element"}, nl = {389}, s = {"L$0", "L$1"}, v = 2)
public final class nh extends ContinuationImpl {
    public uh a;
    public FormElement b;
    public /* synthetic */ Object c;
    public final /* synthetic */ mh d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nh(mh mhVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = mhVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((uh) null, this);
    }
}
