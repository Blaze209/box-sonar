package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.PageLayout", f = "PageLayout.kt", i = {0}, l = {794}, m = "loadSignatureFormElements", n = {"state"}, nl = {791}, s = {"L$0"}, v = 2)
public final class du extends ContinuationImpl {
    public m40 a;
    public /* synthetic */ Object b;
    public final /* synthetic */ au c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du(au auVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = auVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return au.a(this.c, this);
    }
}
