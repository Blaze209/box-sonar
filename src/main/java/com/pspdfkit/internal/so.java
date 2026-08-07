package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.LowResProvider", f = "LowResProvider.kt", i = {0}, l = {177}, m = "renderFullPage", n = {"renderOptions"}, nl = {178}, s = {"L$0"}, v = 2)
public final class so extends ContinuationImpl {
    public jm a;
    public /* synthetic */ Object b;
    public final /* synthetic */ to c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public so(to toVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = toVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
