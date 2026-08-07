package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.instant.annotations.InstantAnnotationProviderImpl", f = "InstantAnnotationProviderImpl.kt", i = {}, l = {303}, m = "synchronizeToBackend", n = {}, nl = {306}, s = {}, v = 2)
public final class xk extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ wk b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk(wk wkVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = wkVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(this);
    }
}
