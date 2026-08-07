package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.LowResProvider", f = "LowResProvider.kt", i = {0, 0, 0, 0}, l = {73}, m = "render", n = {"renderState", "callback", "reuseBitmap", "skipCache"}, nl = {74}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
public final class qo extends ContinuationImpl {
    public Object a;
    public Function2 b;
    public Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ to e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo(to toVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = toVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, false, null, this);
    }
}
